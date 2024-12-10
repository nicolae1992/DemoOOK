package appenginex.com.demoook.domain.models


import com.google.gson.annotations.SerializedName

data class ItemCard(
    @SerializedName("data")
    val dataCard: Data,
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
) {
    val postcards: List<Postcard>
        get() = dataCard.postcards
}