package com.example.listadecompras.Common_Functions

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CommonFunctions {
    companion object{
        fun ToastMessage(message: String,context: Context){
            Toast.makeText(context,"${message}", Toast.LENGTH_LONG).show()
        }
        fun DBReference() : DatabaseReference
        {
            val dbRef =  FirebaseDatabase.getInstance().reference
            return dbRef
        }
        const val TAG = "MessagingService"
    }
}