package com.promagnoli.whichcharacter.entity

import com.google.gson.annotations.SerializedName

data class MarvelResponse (
    @SerializedName("data") val data : Data
)

data class Data (
    @SerializedName("results") val results : List<Results>
)

data class Results (
    @SerializedName("name") val name : String,
    @SerializedName("description") val description : String,
    @SerializedName("thumbnail") val thumbnail : Thumbnail
)

data class Thumbnail (
    @SerializedName("path") val path : String,
    @SerializedName("extension") val extension : String
)