package com.example.listadecompras.DataModels

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
class Product (
    var name: String? = "",
    var price: String? = "",
    var photo: String? = "",
    var brand: String? = "",
    var contNeto: String? = "",
    var buyPlace: String? = "",
    var count: Int = 1,
    var uid: String? = ""

) : Serializable {
    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "name" to name,
            "price" to price,
            "photo" to photo,
            "brand" to brand,
            "contNeto" to contNeto,
            "buyPlace" to buyPlace,
            "count" to count,
            "uid" to uid
        )
    }
    // [END post_to_map]
}