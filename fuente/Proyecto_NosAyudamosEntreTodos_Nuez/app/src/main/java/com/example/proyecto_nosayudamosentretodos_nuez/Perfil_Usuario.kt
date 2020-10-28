package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_perfil__usuario.*

class Perfil_Usuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil__usuario)

        val usuario=intent.getStringExtra("nombre");
        val Usuario_Logueado_2 = usuario

        textView_usuario.text = Usuario_Logueado_2


        btn_subir_articulo.setOnClickListener {

            val intent5: Intent = Intent(this, Subir_Publicacion::class.java)

            startActivity(intent5)

            finish()

        }


        btn_mis_publicaciones.setOnClickListener {

            val intent6: Intent = Intent(this, Mis_Articulos::class.java)

            startActivity(intent6)

            finish()

        }

        btn_lista_usuarios.setOnClickListener {

                val intent7: Intent = Intent(this, Listado_Usuarios::class.java)

                startActivity(intent7)

                finish()

        }

        btn_pagina_principal.setOnClickListener {

            val intent15: Intent = Intent(this, Publicaciones_Usuarios::class.java)

            startActivity(intent15)

            finish()

        }

    }


}

