package com.data.model

import com.google.gson.annotations.SerializedName

class RegistrationData {
    @SerializedName("status_api")
    lateinit var status_api: String
    @SerializedName("name")
    lateinit var name: String
    @SerializedName("mobile")
     var mobile: String="9876754389"
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
    lateinit var longitude: String
    @SerializedName("disease")
    lateinit var disease: ArrayList<String>


}