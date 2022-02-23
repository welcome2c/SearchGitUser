package devhoon.project.searchgituser.data.model

data class SearchResult(
    val id: Int,
    val userid: String,
    val imgUrl: String,
    var favorite: Boolean = false
)