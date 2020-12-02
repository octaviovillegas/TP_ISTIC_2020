package com.example.lubriapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alta_servicios_prueba.*
import kotlinx.android.synthetic.main.activity_baja_servicio.*
import kotlinx.android.synthetic.main.activity_sacar_turno.*
import kotlinx.android.synthetic.main.activity_sacar_turno.BtnVolver

class AltaServiciosPrueba : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alta_servicios_prueba)


        BtnVolver3.setOnClickListener {
            val intent = Intent(this, ABMServicios::class.java)
            startActivity(intent)
            finish()
        }
/*
        BtnAlta3.setOnClickListener{
            //cargarNuevo()
            val admin = AdminSQLiteOpenHelper(this,"articulos", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("codigo", PlainTextNombre.getText().toString())
            registro.put("descripcion", PlainTextFecha.getText().toString())

            bd.insert("articulos", null, registro)
            bd.close()
            PlainTextNombre.setText("")
            PlainTextFecha.setText("")

            Toast.makeText(this, "Se cargaron los datos del artículo", Toast.LENGTH_SHORT).show()
        }*/

    }

   // fun cargarNuevo(){


}
