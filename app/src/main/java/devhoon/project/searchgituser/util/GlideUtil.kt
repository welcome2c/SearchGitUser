package devhoon.project.searchgituser.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

object GlideUtil {

    fun loadImage(
        imageView: ImageView,
        url: String
    ) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }

    fun loadImageTransferCircle(
        imageView: ImageView,
        url: String
    ) {
        Glide.with(imageView.context)
            .load(url)
            .transform(CircleCrop())
            .into(imageView)
    }
}