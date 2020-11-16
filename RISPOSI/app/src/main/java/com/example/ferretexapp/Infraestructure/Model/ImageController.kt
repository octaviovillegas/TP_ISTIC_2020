package com.example.ferretexapp.Infraestructure.Model

import android.app.Activity
import android.content.Intent

object ImageController {
    fun selectPhotoGallery(activity: Activity, code: Int){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        activity.startActivityForResult(intent, code)
    }

}