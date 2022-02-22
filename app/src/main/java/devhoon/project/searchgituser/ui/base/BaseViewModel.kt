package devhoon.project.searchgituser.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel

open class BaseViewModel: ViewModel() {
    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}