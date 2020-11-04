package com.example.ferretexapp.Client.pushnotification

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ferretexapp.Client.pushnotification.apinotification.RetrofitInstancePushNotification
import com.example.ferretexapp.Client.pushnotification.model.NotificationData
import com.example.ferretexapp.Client.pushnotification.model.PushNotification
import com.example.ferretexapp.Client.pushnotification.services.FirebaseService
import com.example.ferretexapp.R
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_home_notification.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val TOPIC = "/topics/myTopic"

class HomeNotification : AppCompatActivity() {

    val TAG="HomeNotification"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_notification)

        /*Esta decapreted a pesar de aparecer en toda la documentación así
        FirebaseService.sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            FirebaseService.token = it.token
            etToken.setText(it.token)
        }*/
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)

        btnSend.setOnClickListener {
            val title = etTitle.text.toString()
            val message=etMessage.text.toString()
            //val recipientToken=etToken.text.toString()
            if(title.isNotEmpty() && message.isNotEmpty() /*&& recipientToken.isNotEmpty()*/){
                PushNotification(
                    NotificationData(title, message),
                    TOPIC//recipientToken
                ).also {
                    sendNotification(it)
                 }
            }
        }
    }
    private fun sendNotification(notification: PushNotification) = CoroutineScope(Dispatchers.IO).launch {
        try{
            val response = RetrofitInstancePushNotification.api.postNotification(notification)
            if(response.isSuccessful){
                Log.d(TAG, "Response: ${Gson().toJson(response)}")
            }else{
                Log.e(TAG,response.errorBody().toString())
            }
        }catch(e: Exception){
            Log.e(TAG, e.toString())
        }
    }

}
