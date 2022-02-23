package devhoon.project.searchgituser.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import devhoon.project.searchgituser.BR
import devhoon.project.searchgituser.R
import devhoon.project.searchgituser.databinding.ItemUserListBinding
import devhoon.project.searchgituser.ui.base.BaseViewHolder

class UserListAdapter: ListAdapter<Item, UserListAdapter.UserListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            BR.item,
            parent,
            R.layout.item_user_list
        )
    }

    override fun getItemViewType(position: Int) = position

    override fun submitList(list: List<Item>?) {
        super.submitList(list?.let { ArrayList(list) })
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    class UserListViewHolder(
        itemId: Int,
        parent: ViewGroup,
        layoutRes: Int
    ): BaseViewHolder<Item, ItemUserListBinding>(itemId, parent, layoutRes)

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}