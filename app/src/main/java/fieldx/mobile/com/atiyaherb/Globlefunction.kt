package fieldx.mobile.com.atiyaherb

import android.content.Context
import android.util.TypedValue

object Globlefunction {
    fun dpToPx(dp: Float, context: Context): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics())
    }
}