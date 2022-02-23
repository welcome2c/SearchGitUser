package devhoon.project.searchgituser.ui.main

import android.os.Bundle
import android.view.View
import devhoon.project.searchgituser.R
import devhoon.project.searchgituser.databinding.FragmentHomeBinding
import devhoon.project.searchgituser.ext.doOnQueryTextSubmit
import devhoon.project.searchgituser.ui.base.BaseFragment
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