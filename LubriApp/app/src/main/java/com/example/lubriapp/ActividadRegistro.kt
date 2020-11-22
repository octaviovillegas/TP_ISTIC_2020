package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import java.io.OutputStreamWriter

class ActividadRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_registro)

        val lblNombre : TextView =findViewById<Button>(R.id.lblNombre)
        val lblApellido : EditText =findViewById<EditText>(R.id.lblApellido)
        val lblMail : EditText =findViewById<EditText>(R.id.lblMail)
        val lblPass : EditText =findViewById<EditText>(R.id.lblPass)
        val btnRegistrarUsuario : Button =findViewById<Button>(R.id.btnRegistrarUsuario)

        btnRegistrarUsuario.setOnClickListener {
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
                val intent: Intent = Intent(this, RegistroExitoso ::class.java)
                startActivity(intent)

                finish()

            }
        }

    }
    private fun altaDeUsuario(nombre:String ,apellido:String,mail:String ,clave:String) //creo la funcion altaDeusuario para registrar a un nuevo usuario
    {

        try {
            val archivo = OutputStreamWriter(openFileOutput("registros.txt", MODE_APPEND)) //guarda a registros.txt en la variable archivo
            archivo.write(nombre + "=>" + apellido+"=>"+mail+"=>" +clave +"\n") //escribe en archivo(registros.txt) el nombre, apellido, mail y clave del nuevo usuario
            archivo.flush()
            archivo.close()
        } catch (e: IOException) {

        }
    }
}
