package fieldx.mobile.com.atiyaherb

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class InfoPageFragment : Fragment() {
    var pageno: Int = 0

    companion object {
        fun newInstance(pagenod: Int) = InfoPageFragment().apply {
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
        } else if (pageno == 4) {
            viewint = R.layout.infopage_five
        }
        var view = inflater.inflate(viewint, container, false)
        return view

    }


}