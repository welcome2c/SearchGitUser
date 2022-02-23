package devhoon.project.searchgituser.data

import devhoon.project.searchgituser.data.response.SearchUsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("users")
    suspend fun getUserList(
        @Query("q") id: String,
        @Query("page") page: Int
    ): SearchUsersResponse

    companion object {
        const val BASE_URL = "https://api.github.com/search/"
    }
}