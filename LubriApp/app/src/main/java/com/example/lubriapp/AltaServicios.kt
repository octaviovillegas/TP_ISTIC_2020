package com.example.lubriapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alta_servicios.*
import kotlinx.android.synthetic.main.activity_baja_servicio.*
import kotlinx.android.synthetic.main.activity_sacar_turno.*

class AltaServicios : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alta_servicios)

        Log.d("ERROR 12 ", "ERROR 12")

        BtnAlta2.setOnClickListener {
            nuevoServicio()
            Log.d("ERROR 1 ", "ERROR 1")


           // lblItem.setText("")
            //lblNumeroItem2.setText("")
        }


        BtnVolver.setOnClickListener {
            val intent = Intent(this, ABMServicios::class.java)
            startActivity(intent)
            finish()
        }
    }


    private fun nuevoServicio() {
        //var retorno:Long= 0L
        Log.d("ERROR 9 ", "ERROR 9")

        if (this.etItem.getText().isNotEmpty() && this.etNombre.getText()
                .isNotEmpty() && this.etFecha.getText().isNotEmpty()
            && this.etHora.getText().isNotEmpty() && this.etAuto.getText().isNotEmpty()
            && this.etServicio.getText().isNotEmpty() && this.etCelular.getText().isNotEmpty())

        {
            Log.d("ERROR 2 ", "ERROR 2")

            var item=this.etItem.getText().toString()
            var nombre=this.etNombre.getText().toString() //cambie el this.getText() por this.text
            var fecha=this.etFecha.getText().toString()
            var hora=this.etHora.getText().toString()
            var auto=this.etAuto.getText().toString()
            var servicio=this.etServicio.getText().toString()
            var celular=this.etCelular.getText().toString()


            try {
                Log.d("ERROR 3 ", "ERROR 3")

                val admin = bdd(this, "SqLite2020", null, 2)
                val bd = admin.writableDatabase
                val registro = ContentValues()
                registro.put("item", item)
                registro.put("nombre", nombre)
                registro.put("fecha", fecha)
                registro.put("hora", hora)
                registro.put("auto", auto)
                registro.put("servicio", servicio)
                registro.put("celular", celular)
                bd.insert("servicios", null, registro)
                Log.d("ERROR 4 ", "ERROR 4")

                //retorno= newId
                bd.close()
                Toast.makeText(this, "la publicacion se subio con exito", Toast.LENGTH_SHORT).show()

                val intent47 = Intent(this, ABMServicios::class.java)

                startActivity(intent47)

                finish()

            } catch (e: Throwable)
            {
                Log.d("ERROR 5 ", "ERROR 5")

                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }


        } else
        {
            Log.d("ERROR 6 ", "ERROR 6")

            Toast.makeText(this, "Los campos no deben estar vacios", Toast.LENGTH_SHORT).show()
            Log.d("ERROR 8", "ERROR 8")

        }
        //return retorno
    }
}










