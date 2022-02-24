package devhoon.project.searchgituser.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import devhoon.project.searchgituser.ui.model.SearchResult
import devhoon.project.searchgituser.data.repository.SearchUserRepository
import devhoon.project.searchgituser.data.response.SearchUsersResponse
import devhoon.project.searchgituser.data.response.toPresentation
import devhoon.project.searchgituser.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainViewModel(
    private val searchUserRepository: SearchUserRepository
) : BaseViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    private val _userList = MutableLiveData<MutableList<SearchResult>>()
    val userList: LiveData<MutableList<SearchResult>> = _userList

    private val _favoriteUserList = MutableLiveData<MutableList<SearchResult>>()
    val favoriteUserList: LiveData<MutableList<SearchResult>> = _favoriteUserList

    private var favoriteMap: HashMap<Int, SearchResult> = hashMapOf()

    private var beforeQuery = ""
    private var page = 1

    private var job: Job? = null

    init {
        _favoriteUserList.value = mutableListOf()
    }

    fun searchUsers(searchId: String) {
        if (beforeQuery != searchId) {
            job?.cancel()
            job = viewModelScope.launch {
                _isLoading.value = true
                beforeQuery = searchId

                searchUserRepository.searchUsers(searchId)
                    .flowOn(Dispatchers.IO)
                    .catch { e ->
                        beforeQuery = ""
                        _errorMsg.value = e.toString()
                    }
                    .collect { response ->
                        _userList.value = checkFavoriteList(response)
                    }
                _isLoading.value = false
            }
        }
    }

    fun loadMore() {
        viewModelScope.launch {
            _isLoading.value = true
            page += 1
            searchUserRepository.loadMore(beforeQuery, page)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _errorMsg.value = e.toString()
                }
                .collect { response ->
                    _userList.value = _userList.value?.apply {
                        addAll(checkFavoriteList(response))
                    }
                }
            _isLoading.value = false
        }
    }

    private fun checkFavoriteList(response: SearchUsersResponse): MutableList<SearchResult> {
        return response.items.toPresentation().onEach { item ->
            if (favoriteMap[item.id] != null) {
                item.isFavorite = true
            }
        }.toMutableList()
    }

    fun addFavoriteList(item: SearchResult) {
        item.isFavorite = true

        _favoriteUserList.value = _favoriteUserList.value?.apply {
            add(item)
        }

        favoriteMap[item.id] = item
    }

    fun removeFavoriteList(item: SearchResult) {
        item.isFavorite = false

        _favoriteUserList.value = _favoriteUserList.value?.apply {
            remove(item)
        }

        favoriteMap.remove(item.id)
    }
}