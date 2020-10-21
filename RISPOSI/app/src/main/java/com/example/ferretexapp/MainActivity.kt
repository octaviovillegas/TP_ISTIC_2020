package com.example.ferretexapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Pair
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        // Agregar animaciones
        val animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)
        val deTextView = findViewById<TextView>(R.id.deTextView)
        val risposiTextView = findViewById<TextView>(R.id.risposiTextView)
        val logoImageView = findViewById<ImageView>(R.id.logoImageView)

        //Definición de la animación de cada componente
        deTextView.animation = animacion2
        risposiTextView.animation = animacion2
        logoImageView.animation = animacion1

        //Función Hnadler para hacer el post de las animaciones y definimos el tiempo que dura el Splash Screen
        Handler().postDelayed({
            val intentSplashScreen = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intentSplashScreen)

        }, 4000)
    }
}