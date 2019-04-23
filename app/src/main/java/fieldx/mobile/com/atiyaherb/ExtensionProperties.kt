package fieldx.mobile.com.atiyaherb

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import android.widget.TextView
import android.widget.Toast


//val Activity.mContext:Context? get() =AndroidApplication.getAppContext()
fun Fragment.close() = fragmentManager?.popBackStack()

fun Activity.showToast(textst: String) {
    val getLayoutInflater = layoutInflater.inflate(R.layout.toast, null)
    val text = getLayoutInflater.findViewById(R.id.text) as TextView
    text.text = textst
    val toast = Toast(this)
    toast.duration = Toast.LENGTH_LONG
    toast.view = getLayoutInflater
    toast.show()
    // Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Activity.startActivityView(classview: Class<*>) {
    startActivity(Intent(applicationContext, classview))
}

