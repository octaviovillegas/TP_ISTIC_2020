package com.example.ferretexapp.Client

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.ferretexapp.Client.ApiConsulta.view.ListadoClima
import com.example.ferretexapp.Client.View.ProductoList
import com.example.ferretexapp.R

class ClientHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_home)

        val imgViewHomeClient = findViewById<ImageView>(R.id.imgViewHomeClient)
        val txtPerfilClient = findViewById<TextView>(R.id.txtPerfilClient)
        val txtSeleccionPerfilClient = findViewById<TextView>(R.id.txtSeleccionPerfilClient)

        val btnComprar = findViewById<Button>(R.id.btnComprar)
        val btnApis=findViewById<Button>(R.id.btnApis)
        val btnHistorial=findViewById<Button>(R.id.btnHistorial)
        val btnValoracion = findViewById<Button>(R.id.btnValoracion)

//==========================================================================================================
        // Agregar animaciones
        val animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)

        imgViewHomeClient.animation = animacion1
        txtPerfilClient.animation = animacion1
        txtSeleccionPerfilClient.animation = animacion1

        btnComprar.animation=animacion2
        btnHistorial.animation=animacion2
        btnApis.animation=animacion2
        btnValoracion.animation=animacion2
//=======================================================================================================


        btnComprar.setOnClickListener(){
            val intentCompras = Intent(this, ProductoList::class.java)
                    startActivity(intentCompras)
        }

        btnApis.setOnClickListener(){
            val intentApis = Intent(this,ListadoClima::class.java)
            startActivity(intentApis)
        }


    }
}
