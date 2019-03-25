package com.binding.adapter

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast


//    @Inject
//    lateinit var context: Context


@BindingAdapter("diseasValidatiorA")
fun diseasValidatior(editText: EditText, text: String) {
    if (text.length < 8) {
        Toast.makeText(editText.context, "Diease Lenght", Toast.LENGTH_SHORT).show()
    }
}

@BindingAdapter("convertListtoString")
fun EditText.convertArrayList(list: ArrayList<String>) {
    this.setText(TextUtils.join(",", list))

}


