package com.data.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableField
import com.google.gson.annotations.SerializedName

class RegistrationData(var stloc: ObservableField<String>) : BaseObservable() {
    @Bindable
    @SerializedName("status_api")
    lateinit var status_api: String


    //var name: String = ""
    @SerializedName("name")
    var name: ObservableField<String> = stloc
        @Bindable
        set(value) {
            stloc = value
            // notifyPropertyChanged(BR.name)
        }
    val test: String
        get() = gender

    @SerializedName("mobile")
    var mobile: String = "9958778861"
    @SerializedName("password")
    lateinit var password: String
    @SerializedName("gender")
    lateinit var gender: String
    @SerializedName("email")
    lateinit var email: String

    @SerializedName("age")
    lateinit var age: String
    @SerializedName("height")
    lateinit var height: String
    @SerializedName("weight")
    lateinit var weight: String
    @SerializedName("latitude")
    lateinit var latitude: String
    @SerializedName("longitude")
    var longitude: String = ""
        get() {
            return field
        }
        set(value) {
            field = value
        }

    @SerializedName("disease")
    lateinit var disease: ArrayList<String>

}