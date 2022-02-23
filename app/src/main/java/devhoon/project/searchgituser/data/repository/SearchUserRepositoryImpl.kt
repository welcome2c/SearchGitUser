package devhoon.project.searchgituser.data.repository

import devhoon.project.searchgituser.data.GitHubApi
import devhoon.project.searchgituser.data.response.SearchUsersResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchUserRepositoryImpl(
    private val gitHubApi: GitHubApi
): SearchUserRepository {
    override fun searchUsers(searchUserId: String): Flow<SearchUsersResponse> {
        return flow {
            val data = gitHubApi.getUserList(searchUserId, 1)
            emit(data)
        }
    }

    override fun loadMore(searchUserId: String, page: Int): Flow<SearchUsersResponse> {
        return flow {
            val data = gitHubApi.getUserList(searchUserId, page)
            emit(data)
        }
    }
}