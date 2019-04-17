package fieldx.mobile.com.atiyaherb

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.widget.Toast

//val Activity.mContext:Context? get() =AndroidApplication.getAppContext()
fun Fragment.close() = fragmentManager?.popBackStack()

fun Activity.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

