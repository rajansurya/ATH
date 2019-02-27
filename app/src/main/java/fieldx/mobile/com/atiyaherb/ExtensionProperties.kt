package fieldx.mobile.com.atiyaherb

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment

//val Activity.mContext:Context? get() =AndroidApplication.getAppContext()
fun Fragment.close() = fragmentManager?.popBackStack()