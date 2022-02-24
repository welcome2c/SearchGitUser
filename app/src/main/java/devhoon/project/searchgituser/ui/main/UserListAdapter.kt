package devhoon.project.searchgituser.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import devhoon.project.searchgituser.BR
import devhoon.project.searchgituser.R
import devhoon.project.searchgituser.ui.model.SearchResult
import devhoon.project.searchgituser.databinding.ItemUserListBinding
import devhoon.project.searchgituser.ui.base.BaseViewHolder

class UserListAdapter(
    val onClickItem: (Int, SearchResult) -> Unit
) : ListAdapter<SearchResult, UserListAdapter.UserListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            BR.item,
            parent,
            R.layout.item_user_list
        )
    }

    override fun getItemViewType(position: Int) = position

    override fun submitList(list: List<SearchResult>?) {
        super.submitList(list?.let { ArrayList(list) })
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bindItem(getItem(position))
        holder.setFavoriteClickListener(position, getItem(position))
    }

    inner class UserListViewHolder(
        itemId: Int,
        parent: ViewGroup,
        layoutRes: Int
    ) : BaseViewHolder<SearchResult, ItemUserListBinding>(itemId, parent, layoutRes) {
        fun setFavoriteClickListener(position: Int, item: SearchResult) {
            itemBinding.icFavorite.setOnClickListener {
                onClickItem(position, item)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SearchResult>() {
            override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}