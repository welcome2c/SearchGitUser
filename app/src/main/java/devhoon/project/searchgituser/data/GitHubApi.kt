package devhoon.project.searchgituser.data

import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("users")
    suspend fun getUserList(
        @Query("q") id: String,
        @Query("page") page: Int
    )

    companion object {
        const val BASE_URL = "https://api.github.com/search/"
    }
}