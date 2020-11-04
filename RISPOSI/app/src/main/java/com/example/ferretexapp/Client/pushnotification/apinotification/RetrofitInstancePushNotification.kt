package com.example.ferretexapp.Client.pushnotification.apinotification

import com.example.ferretexapp.Client.pushnotification.constants.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstancePushNotification {

    companion object {
        private val retrofit by lazy{
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api by lazy{
            retrofit.create(NotificationAPI::class.java)
        }
    }
}