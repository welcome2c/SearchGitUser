package devhoon.project.searchgituser.data.response

import com.google.gson.annotations.SerializedName
import devhoon.project.searchgituser.ui.model.SearchResult

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
        @SerializedName("events_url")
        val events_url: String,
        @SerializedName("followers_url")
        val followers_url: String,
        @SerializedName("following_url")
        val following_url: String,
        @SerializedName("gists_url")
        val gists_url: String,
        @SerializedName("gravatar_id")
        val gravatar_id: String,
        @SerializedName("html_url")
        val html_url: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("login")
        val login: String,
        @SerializedName("node_id")
        val node_id: String,
        @SerializedName("organizations_url")
        val organizations_url: String,
        @SerializedName("received_events_url")
        val received_events_url: String,
        @SerializedName("repos_url")
        val repos_url: String,
        @SerializedName("score")
        val score: Int,
        @SerializedName("site_admin")
        val site_admin: Boolean,
        @SerializedName("starred_url")
        val starred_url: String,
        @SerializedName("subscriptions_url")
        val subscriptions_url: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("url")
        val url: String
    )
}

fun List<SearchUsersResponse.Item>.toPresentation(): List<SearchResult> {
    return this.map {
        SearchResult(
            it.id,
            it.login,
            it.avatar_url
        )
    }
}