package fieldx.mobile.com.atiyaherb

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.EditText
import com.view.callback.ViewCallbAck
import kotlinx.android.synthetic.main.otp_view.*
import javax.inject.Inject

/**
 * Created by Rajan on 13-04-2019.
 */
class OTPAlertDialogFragment : DialogFragment() {

    lateinit var user_Registration: ViewCallbAck
    lateinit var ctx: Context

    companion object {
        fun newInstanse(title: String, luser_Registration: ViewCallbAck, ctxl: Context) = OTPAlertDialogFragment().apply {
            arguments = Bundle().apply {
                putString("title", title)
            }
            user_Registration = luser_Registration
            ctx = ctxl

        }


    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val title = arguments?.getString("title")
        val layoutinflater=LayoutInflater.from(ctx).inflate(R.layout.otp_view,null)
        val textotploc:EditText=layoutinflater.findViewById(R.id.textotp)
        return AlertDialog.Builder(ctx).setTitle(title).setView(layoutinflater).setPositiveButton("GO", DialogInterface.OnClickListener { dialogiterface, whichbutton ->
            user_Registration.otpResponse(textotploc.text.toString())
        }).setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogiterface, whichbutton -> this.dismiss() }).create()
    }

}