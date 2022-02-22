package devhoon.project.searchgituser.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

class BaseActivity<B: ViewDataBinding>(
    private val layoutRes: Int
): AppCompatActivity() {

    private lateinit var dataBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, layoutRes)
        dataBinding.lifecycleOwner = this
    }

    protected fun binding(action: B.() -> Unit) {
        dataBinding.run(action)
    }
}