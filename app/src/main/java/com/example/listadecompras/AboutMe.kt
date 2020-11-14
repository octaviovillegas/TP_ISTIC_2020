package com.example.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutMe : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
    }

    fun backMenuPrincipal(view: View){
        val intentMenuPrincipal = Intent(this,MenuPrincipal::class.java)
        startActivity(intentMenuPrincipal)
        finish()
    }
}