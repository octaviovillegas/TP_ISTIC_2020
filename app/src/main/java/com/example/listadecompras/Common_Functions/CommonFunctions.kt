package com.example.listadecompras.Common_Functions

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.listadecompras.MenuPrincipal
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class CommonFunctions {

    companion object{

        private lateinit var auth: FirebaseAuth

        fun ToastMessage(message: String,context: Context){
            Toast.makeText(context,"${message}", Toast.LENGTH_LONG).show()
        }

        fun DBReference() : DatabaseReference
        {
            val dbRef =  FirebaseDatabase.getInstance().reference
            return dbRef
        }

        fun getUserProfile() {
            // [START get_user_profile]
            val user = Firebase.auth.currentUser
            user?.let {
                // Name, email address, and profile photo Url
                val name = user.displayName
                val email = user.email
                val photoUrl = user.photoUrl

                // Check if user's email is verified
                val emailVerified = user.isEmailVerified

                // The user's ID, unique to the Firebase project. Do NOT use this value to
                // authenticate with your backend server, if you have one. Use
                // FirebaseUser.getToken() instead.
                val uid = user.uid
            }
            // [END get_user_profile]
        }

        const val TAG = "MessagingService"
    }
}