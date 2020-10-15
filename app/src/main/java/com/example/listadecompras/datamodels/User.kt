package com.example.listadecompras.datamodels

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    var user: String? = "",
    var email: String? = ""
) {
    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "user" to user,
            "email" to email
        )
    }
    // [END post_to_map]
}

