package devhoon.project.searchgituser.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import devhoon.project.searchgituser.util.GlideUtil

@BindingAdapter("android:setProfileImageCircle")
fun ImageView.setProfileImageCircle(url: String) {
    GlideUtil.loadImageTransferCircle(this, url)
}

@BindingAdapter("android:setFavoriteSelected")
fun ImageView.setFavoriteSelected(isSelected: Boolean) {
    this.isSelected = isSelected
}