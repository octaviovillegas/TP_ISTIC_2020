package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val BtnRegistrar: Button = findViewById<Button>(R.id.BtnRegistrar)
        val BtnIngresar: Button = findViewById<Button>(R.id.BtnIngresar)
        val lblUsuario: EditText = findViewById<EditText>(R.id.lblUsuario)
        val lblPass: EditText = findViewById<EditText>(R.id.lblPass)

        BtnRegistrar.setOnClickListener {
            val intent2: Intent = Intent(this, ActividadRegistro::class.java)
            startActivity(intent2)
            finish()
        }


        BtnIngresar.setOnClickListener {
            if (lblUsuario.text.toString().isEmpty() or lblPass.text.toString().isEmpty()) {

                Toast.makeText(this, "Campos vacios ", Toast.LENGTH_LONG).show()
            } else {


                UsuarioQuePuedeLogearse()
            }
        }
    } //cierrro el Bundle

    private fun UsuarioQuePuedeLogearse() {

        (fileList().contains("registros.txt"))
        try {

            var banderaUsuario: String = "no"

            val archivo = InputStreamReader(openFileInput("registros.txt"))
            val br = BufferedReader(archivo)
            var linea = br.readLine()
            while (linea != null) {

                val arrayDatos = linea.split("=>")
                if (arrayDatos[2] == lblUsuario.text.toString() && arrayDatos[3] == lblPass.text.toString()) {

                    banderaUsuario = "si"
                    val Usuario_Logueado = lblUsuario.text.toString()
                    val intent: Intent = Intent(this, Cambios::class.java)

                    intent.putExtra("mail", Usuario_Logueado)
                    startActivity(intent)
                    break

                }


                linea = br.readLine()
            }

            if (banderaUsuario == "no") {
                Toast.makeText(this, "Usuario y/o contraseña incorecto ", Toast.LENGTH_LONG).show()

            }

            br.close()
            archivo.close()

        } catch (e: IOException) {
        }
    } //cierro private fun UsuarioQuePuedeLogearse
} //cierro el AppCompatActivity




