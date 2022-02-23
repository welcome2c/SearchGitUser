package devhoon.project.searchgituser.ui.custom

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import devhoon.project.searchgituser.util.DpTransferUtil

class CustomItemDecoration: RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = DpTransferUtil.dpToPx(view.context, 10)
        outRect.top = DpTransferUtil.dpToPx(view.context, 5)
        outRect.bottom = DpTransferUtil.dpToPx(view.context, 5)
    }
}