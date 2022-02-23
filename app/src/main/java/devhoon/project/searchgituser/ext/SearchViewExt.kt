package devhoon.project.searchgituser.ext

import androidx.appcompat.widget.SearchView

fun SearchView.doOnQueryTextSubmit(
    onSubmit: (String) -> Unit = {} ,
    onTextChange: (String) -> Unit = {}
) {
    setOnQueryTextListener(object: SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            onSubmit.invoke(query)
            return true
        }

        override fun onQueryTextChange(newText: String): Boolean {
            onTextChange.invoke(newText)
            return true
        }
    })
}