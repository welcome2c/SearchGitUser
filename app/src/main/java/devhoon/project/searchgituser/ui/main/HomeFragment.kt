package devhoon.project.searchgituser.ui.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import devhoon.project.searchgituser.R
import devhoon.project.searchgituser.databinding.FragmentHomeBinding
import devhoon.project.searchgituser.ext.doOnQueryTextSubmit
import devhoon.project.searchgituser.ui.base.BaseFragment
import devhoon.project.searchgituser.ui.custom.CustomItemDecoration
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment: BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding {
            mainVm = mainViewModel
            searchView.doOnQueryTextSubmit(
                onSubmit = { query ->
                    mainViewModel.searchUsers(query)
                    searchView.clearFocus()
                }
            )
            rvUserList.apply {
                adapter = UserListAdapter() { position, item ->
                    if(!item.favorite) mainViewModel.addFavoriteList(item)
                    adapter?.notifyItemChanged(position)
                }
                addItemDecoration(CustomItemDecoration())
                addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)
                        if(!canScrollVertically(1)) {
                            mainViewModel.loadMore()
                        }
                    }
                })
            }
        }

        observing {
            errorMsg.observe(viewLifecycleOwner) {
                //SnackBar
            }
        }
    }

    private fun observing(action: MainViewModel.() -> Unit) {
        mainViewModel.run(action)
    }
}