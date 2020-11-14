package com.example.listadecompras.Common_Functions

import android.content.Context
import android.util.Log
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.DBReference
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.TAG
import com.example.listadecompras.DataModels.Product
import com.example.listadecompras.DataModels.User
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import java.io.Serializable
import java.net.UnknownServiceException
import kotlin.concurrent.thread
import kotlinx.coroutines.*

class DataBaseFunctions {
    companion object{

        private lateinit var db: FirebaseFirestore

        fun saveUserCloudFirestore(
            name: String,
            userNick: String,
            email: String,
            phone: String,
            userid: String?){
            val userObj = User(name, userNick, email, phone, userid)
            db = FirebaseFirestore.getInstance()
            db.collection("users")
                .add(userObj)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }

        fun saveProductCloudFirestore(
            product: Product, email: String?){
            db = FirebaseFirestore.getInstance()
            db.collection("products").document("productsByUser")
                .collection("$email")
                .add(product)
                .addOnSuccessListener { documentReference ->
                    Log.d(CommonFunctions.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(CommonFunctions.TAG, "Error adding document", e)
                }
        }

//        fun getProducts(email: String?) : ArrayList<Product> {
//            val arrayProduct = ArrayList<Product>()
//            lateinit var product: Product
//            thread {
//                db = FirebaseFirestore.getInstance()
//                var task = db.collection("products").document("productsByUser")
//                    .collection("$email")
//                    .get()
//                    .addOnSuccessListener { result ->
//                        for (document in result) {
//                            product = Product(
//                                document.getString("name"),
//                                document.getString("price"),
//                                document.getString("photo"),
//                                document.getString("brand"),
//                                document.getString("contNeto"),
//                                document.getString("buyPlace"),
//                                document["count"].toString().toInt(),
//                                document.getString("uid"))
//                            arrayProduct.add(product)
//                            Log.d(TAG, "${document.data}")
//                        }
//                        Thread.sleep(1000)
//                    }
//                    .addOnFailureListener { exception ->
//                        Log.w(TAG, "Error getting documents.", exception)
//                    }
//            }
//            return if (task.isSuccessful){
//                arrayProduct
//            } else{
//                arrayProduct
//            }
//        }

        fun saveUserRealtimeDatabase(name: String, user: String, email: String, phone: String,context: Context){
            try {
                val dbRef = DBReference()
                val key = dbRef.child("users").push().key
                val userObj = User(name, user, email, phone, key)
                val postValues = userObj.toMap()
                val childUpdates = HashMap<String, Any>()
                childUpdates["/users/$key"] = postValues
                dbRef.updateChildren(childUpdates)
            }
            catch (ex: Throwable) {
                CommonFunctions.ToastMessage("Error: ${ex.message}", context)
            }
        }



    }
}