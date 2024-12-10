package appenginex.com.demoook.domain.models


import com.google.gson.annotations.SerializedName

data class Postcard(
    @SerializedName("hasGif")
    val hasGif: Boolean,
    @SerializedName("image")
    val image: String,
)