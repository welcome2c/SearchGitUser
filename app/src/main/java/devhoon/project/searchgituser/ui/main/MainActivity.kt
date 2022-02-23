package devhoon.project.searchgituser.ui.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import devhoon.project.searchgituser.R
import devhoon.project.searchgituser.databinding.ActivityMainBinding
import devhoon.project.searchgituser.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_container) as NavHostFragment
        navController = navHostFragment.navController

        binding {
            mainVm = mainViewModel
            navController = navHostFragment.navController
            bottomNavigation.setupWithNavController(navController)
        }
    }
}