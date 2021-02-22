package com.example.parcial_julissa.datamodels

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Persona(
    var nombre: String? = "",
    var dni: String?=""
    //var phone: String? = ""
) {
    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "nombre" to nombre,
            "dni" to dni
        )
    }
}