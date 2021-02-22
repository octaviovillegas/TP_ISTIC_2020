package com.example.parcial_julissa.datamodels

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    var name: String? = "",
    var dni: String? = "",
    var tarjeta: String? = "",
    var birthday: String? = "",
    var direccion: String? = "",
    var saldo: Number? = 0,
    var email: String? = ""
    //var phone: String? = ""
) {
    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "name" to name,
            "dni" to dni,
            "email" to email,
            "birthday" to birthday,
            "direccion" to direccion,
            "saldo" to saldo,
            "tarjeta" to tarjeta
        )
    }

}
