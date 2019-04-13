package com.binding.adapter

import android.databinding.BindingAdapter
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast


@BindingAdapter("diseasValidatiorA")
fun diseasValidatior(editText: EditText, text: String) {
    //if (text.length < 8) {
       // Toast.makeText(editText.context, "Disease Length", Toast.LENGTH_SHORT).show()
   // }
}

@BindingAdapter("convertListtoString")
fun EditText.convertArrayList(list: ArrayList<String>) {
    this.setText(TextUtils.join(",", list))

}


