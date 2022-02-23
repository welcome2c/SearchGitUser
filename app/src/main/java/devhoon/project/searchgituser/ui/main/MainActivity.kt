package devhoon.project.searchgituser.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import devhoon.project.searchgituser.R
import devhoon.project.searchgituser.databinding.ActivityMainBinding
import devhoon.project.searchgituser.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}