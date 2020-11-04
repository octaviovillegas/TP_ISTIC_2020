package com.example.ferretexapp.Client.pushnotification

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService(){
    //Estas lineas es para hacer una notificación en Primer Plano
    override fun onMessageReceived(remoteMessage:RemoteMessage) {
        Looper.prepare()
        Handler().post{
            Toast.makeText(baseContext, remoteMessage.notification?.title,Toast.LENGTH_LONG).show()
        }
        Looper.loop()
    }
}