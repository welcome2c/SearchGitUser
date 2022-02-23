package devhoon.project.searchgituser.data.response

import com.google.gson.annotations.SerializedName

data class SearchUsersResponse(
    @SerializedName("incomplete_results")
    val incomplete_results: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val total_count: Int
)