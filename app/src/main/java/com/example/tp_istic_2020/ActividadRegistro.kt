package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_actividad_registro.*
import java.io.IOException
import java.io.OutputStreamWriter

class ActividadRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_registro)
        val lblNombre : TextView =findViewById<Button>(R.id.lblNombre)
        val lblApellido : TextView =findViewById<TextView>(R.id.lblApellido)
        val lblMail : TextView =findViewById<TextView>(R.id.lblMail)
        val lblPass : TextView =findViewById<TextView>(R.id.lblPass)
        val btn_resgitro : Button =findViewById<Button>(R.id.btn_registro)

        btn_registro.setOnClickListener {
            if (lblNombre.text.toString().isEmpty() or lblApellido.text.toString().isEmpty() or lblMail.text.toString().isEmpty() or lblPass.text.toString().isEmpty() )
            {

                Toast.makeText(this, "Campos vacios ", Toast.LENGTH_LONG).show()
            }
            else
            {

                altaDeUsuario(
                    lblNombre.text.toString(),
                    lblApellido.text.toString(),
                    lblMail.text.toString(),
                    lblPass.text.toString()
                )
                val intent: Intent = Intent(this, OkRegistro ::class.java)
                startActivity(intent)

                finish()

            }
        }

    }
    private fun altaDeUsuario(nombre:String ,apellido:String,mail:String ,clave:String)
    {

        try {
            val archivo = OutputStreamWriter(openFileOutput("registros.txt", MODE_APPEND))
            archivo.write(nombre + "=>" + apellido+"=>"+mail+"=>" +clave +"\n")
            archivo.flush()
            archivo.close()
        } catch (e: IOException) {

        }
    
    }
}