package devhoon.project.searchgituser.ui.main

import android.os.Bundle
import android.view.View
import devhoon.project.searchgituser.R
import devhoon.project.searchgituser.databinding.FragmentFavoriteBinding
import devhoon.project.searchgituser.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoriteFragment: BaseFragment<FragmentFavoriteBinding>(R.layout.fragment_favorite) {
    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding {
            mainVm = mainViewModel
        }

        observing {

        }
    }

    private fun observing(action: MainViewModel.() -> Unit) {
        mainViewModel.run(action)
    }
}