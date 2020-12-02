package com.example.lubriapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_confirmar_turno.*

class ABMServicios : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_turno)

        //Esta activity solo la ven los empleados


        val BtnAlta : Button =findViewById<Button>(R.id.BtnAlta) //busco lps botones
        val BtnModificar : Button =findViewById<Button>(R.id.BtnModificar)
        val BtnEliminar : Button =findViewById<Button>(R.id.BtnEliminar)
        val BtnTurnos : Button =findViewById<Button>(R.id.BtnTurnos)


        BtnAlta.setOnClickListener {
            val intent4 = Intent(this, AltaServiciosPrueba::class.java)
            d("ERROR 18 ", "ERROR 18")

            startActivity(intent4)
            d("ERROR 7 ", "ERROR 7")

        }

        BtnModificar.setOnClickListener {
            val intent5 = Intent(this, AltaServicios::class.java) //en un solo
            startActivity(intent5)
        }

        BtnEliminar.setOnClickListener {
            val  intent6 = Intent(this, BajaServicio::class.java)
            startActivity(intent6)
        }

        BtnTurnos.setOnClickListener {
            val  intent7 = Intent(this, ListaTurnos::class.java)
            startActivity(intent7)
        }


    }
}