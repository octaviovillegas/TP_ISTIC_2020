package com.example.ferretexapp.Client.pushnotification.apinotification

import android.app.Notification
import com.example.ferretexapp.Client.pushnotification.constants.Constants.Companion.CONTENT_TYPE
import com.example.ferretexapp.Client.pushnotification.constants.Constants.Companion.SERVER_KEY
import com.example.ferretexapp.Client.pushnotification.model.PushNotification
import com.squareup.okhttp.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface NotificationAPI {

    @Headers("Authorization: key=$SERVER_KEY", "Content-Typer: $CONTENT_TYPE")
    @POST("/fcm/send")
    suspend fun postNotification(
        @Body notification: PushNotification
        ): Response<ResponseBody>
    }

