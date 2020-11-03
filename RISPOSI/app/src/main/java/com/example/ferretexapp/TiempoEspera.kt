package com.example.ferretexapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView
import com.example.ferretexapp.Client.ClientHome
import kotlinx.android.synthetic.main.activity_tiempo_espera.*

class TiempoEspera : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiempo_espera)

//==================================================
//Accedemos a la imagen

        // Handler().postDelayed({
//======================================================
             // Versión Disney aplicando a mano
            //likeImageView.setAnimation(animation)
            //likeImageView.playAnimation()
//======================================================
            //Aplicando funcion
            val tvIngreso = findViewById<TextView>(R.id.tvIngreso)
            val btnPantallaVolverInicio = findViewById<Button>(R.id.btnPantallaVolverInicio)
            val animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
            val animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)

            tvIngreso.animation = animacion1
            btnPantallaVolverInicio.animation=animacion2

            val Paso = true

            var like = false
            likeImageView.setOnClickListener {
                likeAnimation(likeImageView, R.raw.bandai_dokkan, like = true)
                like = likeAnimation(likeImageView,R.raw.bandai_dokkan, like)
                tvIngreso.isEnabled==false

                //Versión 1
                // val Paso = 1

                //Versión 2
                //NextScreen()

                //Versión 3
                //likeImageView.isInitialized?

                //Versión 4
                //likeImageView.hasEnded==false

                //Version 5 pero no encontre el metodo
                //if(likeImageView.animationlister)
            }

        btnPantallaVolverInicio.setOnClickListener(){
            val intentVolverInicio = Intent(this,LoginActivity::class.java)
            startActivity(intentVolverInicio)
        }

//Condicion para pasar de pantalla

            Handler().postDelayed({
                if(tvIngreso.isEnabled==false){
                   if(likeImageView.animation.hasEnded()==true){
                       val intentClientHome = Intent(this@TiempoEspera, ClientHome::class.java)
                       startActivity(intentClientHome)
                       //NextScreen()
                   }
                }
        }, 4000)




    }

    private fun likeAnimation(imageView: LottieAnimationView,
                              animation: Int,
                              like:Boolean):Boolean{
        if(!like){
            imageView.setAnimation(animation)
            imageView.playAnimation()
        }else{
            imageView.animate()
                .alpha(0f)
                .setDuration(4000)
                .setListener(object: AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator?) {

                        imageView.setImageResource(R.drawable.twitter_like)
                        imageView.alpha = 1f
                    }
                })
        }
        return !like
        //imageView.setAnimation(animation)
        //imageView.playAnimation()
    }


    private fun NextScreen(){
        val intentClientHome = Intent(this@TiempoEspera, ClientHome::class.java)
        startActivity(intentClientHome)
    }

}

