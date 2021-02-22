package com.example.parcial_julissa.datamodels

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties



@IgnoreExtraProperties
data class Envio(
    var uid: String? = "",
    var monto: Float?
    //var phone: String? = ""
) {
    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "uid" to uid,
            "monto" to monto
        )
    }
}
// [END post_to_map]