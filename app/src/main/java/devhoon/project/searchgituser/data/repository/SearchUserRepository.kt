package devhoon.project.searchgituser.data.repository

import devhoon.project.searchgituser.data.response.SearchUsersResponse
import kotlinx.coroutines.flow.Flow

interface SearchUserRepository {
    fun searchUsers(
        searchUserId: String
    ): Flow<SearchUsersResponse>

    fun loadMore(
        searchUserId: String,
        page: Int
    ): Flow<SearchUsersResponse>
}