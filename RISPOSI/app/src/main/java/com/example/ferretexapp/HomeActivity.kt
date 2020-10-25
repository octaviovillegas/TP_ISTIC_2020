package com.example.ferretexapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.ferretexapp.Client.ClientHome
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//===============================================================================================
        //Definicion de las variables para la animación
        val imgViewHome = findViewById<ImageView>(R.id.imgViewHome)
        val txtPerfil=findViewById<TextView>(R.id.txtPerfil)
        val txtSeleccionPerfil=findViewById<TextView>(R.id.txtSeleccionPerfil)
        val btnDueno=findViewById<Button>(R.id.btnDueno)
        val btnCliente=findViewById<Button>(R.id.btnCliente)
//===============================================================================================
        //Animaciones
        val animacionParaArriba = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacionParaABajo=AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo)

        imgViewHome.animation = animacionParaABajo
        txtPerfil.animation = animacionParaABajo
        txtSeleccionPerfil.animation=animacionParaABajo
        btnDueno.animation=animacionParaArriba
        btnCliente.animation=animacionParaArriba
//===============================================================================================

        btnCliente.setOnClickListener(){
            val intentClient = Intent(this, ClientHome::class.java)
                    startActivity(intentClient)
        }
        /*
        btnDueno.setOnClickListener(){
            val intentDueno = Intent(this, DuenoHome::class.java)
            startActivity(intentDueno)
        }
        */


    }
}
