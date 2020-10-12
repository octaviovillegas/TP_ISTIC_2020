package com.example.ferretexapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
class MainActivity AppCompatActivity {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(windowManager.LayoutParams.FLAG_FULLSCREEN, windowManager.layoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Agregar Animaciones
        Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        TextView risposiTextView = findViewById(R.id.risposiTextView)
        TextView deTextView = findViewById(R.id.deTextView)
        ImageView logoImageView = findViewById(R.id.logoImageView)

        risposiTextView.setAnimation(animacion2);
        deTextView.setAnimation(animacion2);
        logoImageView.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(MainActivity.this, LoginActivity.class)
                startActivity(intent)
                finish()
            }
        }, delayMills: 4000)
    }
}

 */


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            FLAG_FULLSCREEN,
            FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        // Agregar animaciones
        val animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)
        val deTextView = findViewById<TextView>(R.id.deTextView)
        val risposiTextView = findViewById<TextView>(R.id.risposiTextView)
        val logoImageView =
            findViewById<ImageView>(R.id.logoImageView)
        deTextView.animation = animacion2
        risposiTextView.animation = animacion2
        logoImageView.animation = animacion1
        Handler().postDelayed({
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}