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
            /*
            etItem.setText("")
            etNombre.setText("") //dejo los campos del xml vacios
            etFecha.setText("")
            etHora.setText("")
            etAuto.setText("")
            etServicio.setText("")
            etCelular.setText("")*/

        }
    }  //aca termina el bundle

        private fun agregarTurno() { //creo la funcion privada que se ejecuta cuando hacen click en el btn agregar servicio
            if(this.etNombre.getText().isNotEmpty()&&this.etFecha.getText().isNotEmpty()&&this.etHora.getText().isNotEmpty()&&this.etAuto.getText().isNotEmpty()&&this.etServicio.getText().isNotEmpty()&&this.etCelular.getText().isNotEmpty() )

            {
/*
                var item=this.etItem.getText().toString()
                var nombre=this.etNombre.getText().toString()
                var fecha=this.etFecha.getText().toString()
                var hora=this.etHora.getText().toString()
                var auto=this.etAuto.getText().toString()
                var servicio=this.etServicio.getText().toString()
                var celular=this.etCelular.getText().toString()
*/

                try {
                    val admin = bdd(this,"SqLite2020", null, 2)
                    val bd = admin.writableDatabase
                    val registro = ContentValues()
                    registro.put("item", etItem.getText().toString())
                    registro.put("nombre",etNombre.getText().toString()) //lo que esta en verde son las keys de la base de datos bdd, lo que esta en negro es el valo que estoy cargando en ella
                    registro.put("fecha",etFecha.getText().toString())
                    registro.put("hora",etHora.getText().toString())
                    registro.put("auto",etAuto.getText().toString())
                    registro.put("servicio",etServicio.getText().toString())
                    registro.put("celular",etCelular.getText().toString())

                    bd.insert("servicios", null, registro)
                    bd.close()
                    etItem.setText("")
                    etNombre.setText("") //dejo los campos del xml vacios
                    etFecha.setText("")
                    etHora.setText("")
                    etAuto.setText("")
                    etServicio.setText("")
                    etCelular.setText("")
                    Toast.makeText(this, "Servicio subido correctamente", Toast.LENGTH_SHORT).show()
                }catch (e:Throwable)
                {
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                }

            }else
            {
                Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show()
            }

        }
}







