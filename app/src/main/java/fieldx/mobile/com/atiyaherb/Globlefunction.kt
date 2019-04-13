package fieldx.mobile.com.atiyaherb

import android.content.Context
import android.util.TypedValue
import android.graphics.drawable.ColorDrawable
import android.view.Window.FEATURE_NO_TITLE
import android.app.ProgressDialog
import android.view.Window


object Globlefunction {
    fun dpToPx(dp: Float, context: Context): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics())
    }


    fun getProgressDialog(ctx: Context): ProgressDialog {
        val dialog = ProgressDialog(ctx)
        try {
            dialog.setCancelable(false)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.show()
            dialog.setContentView(R.layout.custom_dialog)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return dialog
    }
}