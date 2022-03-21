package com.example.qminsample.viewmodel

import com.google.gson.annotations.SerializedName

data class Common(val data: List<UserData>? = null)

data class UserData(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("field")
    var field: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("message")
    var message: String? = null
)