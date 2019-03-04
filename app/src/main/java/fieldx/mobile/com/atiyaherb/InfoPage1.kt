package fieldx.mobile.com.atiyaherb

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class InfoPage1 : Fragment(), View.OnClickListener {
    override fun onClick(p0: View) {
        when (p0.id) {

        }
    }

    var pageno: Int = 0
    lateinit var infopage: InfoPage

    companion object {
        fun newInstance(pagenod: Int) = InfoPage1().apply {
            arguments = Bundle(2).apply {
                putInt("MY_BOOLEAN", pagenod)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var viewint: Int = 0
        pageno = arguments!!.getInt("MY_BOOLEAN")
        if (pageno == 0) {
            viewint = R.layout.infopage_one
        } else if (pageno == 1) {
            viewint = R.layout.infopage_two
        } else if (pageno == 2) {
            viewint = R.layout.infopage_three
        } else if (pageno == 3) {
            viewint = R.layout.infopage_fourth
        }
        var view = inflater.inflate(viewint, container, false)
        return view

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        infopage = context as InfoPage
    }

}