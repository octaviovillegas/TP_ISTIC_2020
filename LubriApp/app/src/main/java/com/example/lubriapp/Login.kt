package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

   private var clave = "12345678910" //traer de la base de datos con una funcion conectada con sql lite, en el proyecto del profe esta como hacerlo con sql lite
                                    // que cada empleado tenga un perfil propio con su clave, asi puedo saber quien entra
                                    // con clientes hago lo mismo, cada cliente puede loguearse y se lo redirige a una activity especifica

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       var valorIngresado: String = (editText.text.toString()) // declaro la variable dodne se guarda lo que ingresa el usuario por teclado

        BtnVerificar.setOnClickListener { //Cuando aprietan el boton de verificar, entra al if para checkear que la clave sea la correcta

            if (clave == valorIngresado) {
                val intento = Intent(this, Cambios::class.java)
                startActivity(intento)
            } else {
                Toast.makeText(this, "Clave incorrecta, vuelva a intentarlo", Toast.LENGTH_SHORT)
            }
        }




    }
}
