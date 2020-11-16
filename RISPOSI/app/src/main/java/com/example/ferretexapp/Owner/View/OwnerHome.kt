package com.example.ferretexapp.Owner.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.ferretexapp.Client.View.ProductoList
import com.example.ferretexapp.Infraestructure.Prinpal
import com.example.ferretexapp.Owner.BDProductos.ViewModelOwner
import com.example.ferretexapp.R

class OwnerHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_home)

        val imgViewHomeOwner = findViewById<ImageView>(R.id.imgViewHomeOwner)
        val txtPerfilOwner = findViewById<TextView>(R.id.txtPerfilOwner)
        val txtSeleccionPerfilOwner = findViewById<TextView>(R.id.txtSeleccionPerfilOwner)

        val btnProductos = findViewById<Button>(R.id.btnProductos)
        val btnGanancias=findViewById<Button>(R.id.btnGanancias)
        val btnVentas  = findViewById<Button>(R.id.btnVentas)

//==========================================================================================================
        // Agregar animaciones
        val animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)

        imgViewHomeOwner.animation = animacion1
        txtPerfilOwner.animation = animacion1
        txtSeleccionPerfilOwner.animation = animacion1

        btnProductos.animation=animacion2
        btnGanancias.animation=animacion2
        btnVentas.animation=animacion2
//=======================================================================================================


        btnProductos.setOnClickListener(){
            val intentProductos = Intent(this, Prinpal::class.java)
            startActivity(intentProductos)
        }
    }
}
