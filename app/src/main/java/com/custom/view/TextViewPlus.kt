package com.custom.view

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import android.graphics.Typeface
import android.util.Log
import com.custom.view.TextViewPlus
import android.content.res.TypedArray
import fieldx.mobile.com.atiyaherb.R


/**
 * Created by Rajan on 01-03-2019.
 */
class TextViewPlus constructor(context:Context):TextView(context){
    private val TAG = "TextView"
    constructor(context:Context,  attrs: AttributeSet):this(context){
        setCustomFont(context,attrs)
    }
    constructor(context:Context,  attrs: AttributeSet,defStyle:Int):this(context, attrs){
        setCustomFont(context,attrs)
    }
    fun setCustomFont( ctx:Context,  attrs:AttributeSet){
        val a = ctx.obtainStyledAttributes(attrs, R.styleable.TextViewPlus)
        val customFont = a.getString(R.styleable.TextViewPlus_setCustomFont)
        setCustomFont(ctx, customFont)
        a.recycle()
    }
    fun setCustomFont( ctx:Context,  asset:String):Boolean{
        var tf: Typeface? = null
        try {
            tf = Typeface.createFromAsset(ctx.assets, "fonts/"+asset)
        } catch (e: Exception) {
            Log.e(TAG, "Could not get typeface: " + e.message)
            return false
        }


        typeface = tf
        return true
    }
}