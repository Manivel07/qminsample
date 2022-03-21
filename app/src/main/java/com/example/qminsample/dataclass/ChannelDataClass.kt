package com.example.qminsample.dataclass

import com.google.gson.annotations.SerializedName

data class GenericList(var generic_channels: List<GenericData>)

data class GenericData(
    var name: String,
    var id: String,
    var image_url: String? = null,
    var body_hero_text: String,

)


data class GenericChannel(
    var statusCode: String,
    var message: String,
    var result: GenericList
)
