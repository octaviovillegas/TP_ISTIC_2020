package com.example.lubriapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alta_servicios.*
import kotlinx.android.synthetic.main.activity_sacar_turno.*

class AltaServicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alta_servicios)

        BtnVolver.setOnClickListener {
            val intent = Intent(this, ABMServicios::class.java)
            startActivity(intent)
        }

        BtnAlta2.setOnClickListener {
            val admin = bdd(this, "servicios", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("item", etItem.getText().toString())
            registro.put("nombre", etNombre.getText().toString())
            registro.put("fecha", etFecha.getText().toString())
            registro.put("hora", etHora.getText().toString())
            registro.put("servicio", etServicio.getText().toString())
            registro.put("auto", etAuto.getText().toString())
            registro.put("celular", etCelular.getText().toString())

            bd.insert("servicios", null, registro)
            bd.close()
            etItem.setText("")
            etNombre.setText("") //dejo los campos del xml vacios
            etFecha.setText("")
            etHora.setText("")
            etAuto.setText("")
            etServicio.setText("")
            etCelular.setText("")

            Toast.makeText(this, "Se cargaron los datos del artículo", Toast.LENGTH_SHORT).show()
        }

        BtnItem.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "servicios", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery(
                "select nombre,auto from servicios where item=${etItem.text.toString()}",
                null
            )
            if (fila.moveToFirst()) {
                etNombre.setText(fila.getString(0))
                etAuto.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un servicio con dicho item", Toast.LENGTH_SHORT)
                    .show()
            bd.close()
        }
    }
}









/*
        val etItem: EditText = findViewById<EditText>(R.id.etItem)
        val etNombre: EditText = findViewById<EditText>(R.id.etNombre)
        val etFecha: EditText = findViewById<EditText>(R.id.etFecha)
        val etHora: EditText = findViewById<EditText>(R.id.etHora)
        val etAuto: EditText = findViewById<EditText>(R.id.etAuto)
        val etServicio: EditText = findViewById<EditText>(R.id.etServicio)
        val etCelular: EditText = findViewById<EditText>(R.id.etCelular) //dice que no son usados porque esta dentro del bundle, mientras que el llamado esta mas abajo, fuera del bundle


        BtnVolver.setOnClickListener {
            val intent = Intent(this, ABMServicios::class.java)
            startActivity(intent)
        }

        BtnAlta2.setOnClickListener {
            agregarTurno() //cuando aprientan el boton, se ejecuta la funcion privada agregarTurno, una vez que finaliza, se vuelve a dejar los campos vacios del xml para ingresar otro turno
            /* VERSION DE MAURICIO
            etItem.setText("")
            etNombre.setText("") //dejo los campos del xml vacios
            etFecha.setText("")
            etHora.setText("")
            etAuto.setText("")
            etServicio.setText("")
            etCelular.setText("") */

        }
    }  //aca termina el bundle

    private fun agregarTurno() {
//creo la funcion privada que se ejecuta cuando hacen click en el btn agregar servicio

        /*val etItem: EditText = findViewById<EditText>(R.id.etItem)
                val etNombre = findViewById<EditText>(R.id.etNombre)
                val etFecha: EditText = findViewById<EditText>(R.id.etFecha)
                val etHora: EditText = findViewById<EditText>(R.id.etHora)
                val etAuto: EditText = findViewById<EditText>(R.id.etAuto)
                val etServicio: EditText = findViewById<EditText>(R.id.etServicio) //nueva manera, en apkVersion_25
                val etCelular: EditText = findViewById<EditText>(R.id.etCelular) nueva manera, en apkVersion_26 */


        //if(this.etNombre.getText().isNotEmpty()&&this.etFecha.getText().isNotEmpty()&&this.etHora.getText().isNotEmpty()&&this.etAuto.getText().isNotEmpty()&&this.etServicio.getText().isNotEmpty()&&this.etCelular.getText().isNotEmpty() )

        if (this.etNombre.text.isNotEmpty() && this.etFecha.text.isNotEmpty() && this.etHora.text.isNotEmpty() && this.etAuto.text.isNotEmpty() && this.etServicio.text.isNotEmpty() && this.etCelular.text.isNotEmpty()) //nueva manera, en apkVersion_26
        {


            /*
                var item=this.etItem.getText().toString()
                var nombre=this.etNombre.getText().toString()
                var fechas=this.etFecha.getText().toString()
                var hora=this.etHora.getText().toString()
                var auto=this.etAuto.getText().toString() //esto no se usa porque se lo implementa en registro.put("item", etItem.text.toString())
                var service=this.etServicio.getText().toString()
                var num=this.etCelular.getText().toString() VERSION DE MAURICIO */


            try {
                val admin = bdd(this, "SqLite2020", null, 1) //atencion: en el codigo del tutorial es version:1. Mientras que ne el de Mauricio es 2
                val bd = admin.writableDatabase
                val registro = ContentValues()

                registro.put("item", etItem.getText().toString()) //version del tutorial
                registro.put("nombre", etNombre.getText().toString())
                registro.put("fecha", etFecha.getText().toString())
                registro.put("hora", etHora.getText().toString())
                registro.put("auto", etAuto.getText().toString())
                registro.put("servicio", etServicio.getText().toString())
                registro.put("celular", etCelular.getText().toString())


                /*
                    registro.put("item",item)
                    //registro.put("item", etItem.getText.toString()) //asi estaba antes
                    //registro.put("nombre",etNombre.text.toString()) //lo que esta en verde son las keys de la base de datos bdd, lo que esta en negro es el valo que estoy cargando en ella. modificado y aparecen en el apkVersion_24
                    registro.put("nombre",nombre)
                    registro.put("fecha",fechas)
                    registro.put("hora",hora)
                    registro.put("auto",auto)
                    registro.put("servicio",service)
                    registro.put("celular",num) VERSION DE MAURICIO */

                bd.insert("servicios", null, registro)
                bd.close()
                etItem.setText("")
                etNombre.setText("") //dejo los campos del xml vacios, version del tutorial
                etFecha.setText("")
                etHora.setText("")
                etAuto.setText("")
                etServicio.setText("")
                etCelular.setText("")
                Toast.makeText(this, "Servicio subido correctamente", Toast.LENGTH_SHORT).show()
            } catch (e: Throwable) {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show()
            }
    }
} */







