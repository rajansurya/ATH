package fieldx.mobile.com.atiyaherb

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.TypedValue
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
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        /*val dialog: AlertDialog = SpotsDialog.Builder()
                .setContext(ctx)
                .setMessage("Please Wait...")
                .setCancelable(false)
                .build()*/



        return dialog
    }
}