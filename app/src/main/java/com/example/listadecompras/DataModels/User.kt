package com.example.listadecompras.DataModels

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    var name: String? = "",
    var user: String? = "",
    var email: String? = "",
    var phone: String? = ""
) {
    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "name" to name,
            "user" to user,
            "email" to email,
            "phone" to phone
        )
    }
    // [END post_to_map]
}

