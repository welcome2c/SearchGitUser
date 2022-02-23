package devhoon.project.searchgituser.data.response

import com.google.gson.annotations.SerializedName
import devhoon.project.searchgituser.data.model.SearchResult

data class SearchUsersResponse(
    @SerializedName("incomplete_results")
    val incomplete_results: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val total_count: Int
) {
    data class Item(
        @SerializedName("avatar_url")
        val avatar_url: String,
        @SerializedName("avatar_url")
        val events_url: String,
        @SerializedName("avatar_url")
        val followers_url: String,
        @SerializedName("avatar_url")
        val following_url: String,
        @SerializedName("avatar_url")
        val gists_url: String,
        @SerializedName("avatar_url")
        val gravatar_id: String,
        @SerializedName("avatar_url")
        val html_url: String,
        @SerializedName("avatar_url")
        val id: Int,
        @SerializedName("avatar_url")
        val login: String,
        @SerializedName("avatar_url")
        val node_id: String,
        @SerializedName("avatar_url")
        val organizations_url: String,
        @SerializedName("avatar_url")
        val received_events_url: String,
        @SerializedName("avatar_url")
        val repos_url: String,
        @SerializedName("avatar_url")
        val score: Int,
        @SerializedName("avatar_url")
        val site_admin: Boolean,
        @SerializedName("avatar_url")
        val starred_url: String,
        @SerializedName("avatar_url")
        val subscriptions_url: String,
        @SerializedName("avatar_url")
        val type: String,
        @SerializedName("avatar_url")
        val url: String
    )
}

fun List<SearchUsersResponse.Item>.toPresentation(): List<SearchResult> {
    return this.map {
        SearchResult(
            it.login,
            it.avatar_url
        )
    }
}