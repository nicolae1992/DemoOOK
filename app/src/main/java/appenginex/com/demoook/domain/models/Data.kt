package appenginex.com.demoook.domain.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("postcards")
    val postcards: List<Postcard>
)