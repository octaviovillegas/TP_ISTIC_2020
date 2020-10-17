package com.example.dinvercalculos

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*
import java.io.IOException
import java.util.regex.Pattern

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val botonRegistrarMail = findViewById<Button>(R.id.btnRegistrarme)

        botonRegistrarMail.setOnClickListener{
            registrarUsuario()
        }
    }


    //Funcion para registrar usuario
    private fun registrarUsuario()
    {
        try {
            if(registroVacio()==false)
            {
                claseFunciones.ttoas("Todos los campos son obligatorios",this)
            }else
            {
                if (!validarEmail(txtMailUsuario.text.toString()))
                {
                    claseFunciones.ttoas("Email no válido",this)
                    this.txtMailUsuario.error = "Debes ingresar un email valido"
                    this.txtMailUsuario.requestFocus()
                }else
                {
                    if (chequeaClave()==false)
                    {
                        claseFunciones.ttoas("Las claves deben coincidir",this)
                        this.txtRegistroClave.error = "Claves no coinciden"
                        this.txtRegistroRepClave.error = "Claves no coinciden"
                        this.txtRegistroClave.requestFocus()
                        this.txtRegistroRepClave.requestFocus()
                    }else
                    {
                        if (largoclave() == true)
                        {
                            this.txtRegistroClave.error = "Minimo 6 caracteres"
                            this.txtRegistroClave.requestFocus()
                        } else
                        {
                            FirebaseAuth.getInstance().createUserWithEmailAndPassword(txtMailUsuario.text.toString(),
                                txtRegistroClave.text.toString()).addOnCompleteListener {
                                if (it.isSuccessful) {
                                    val UsuarioOk = txtMailUsuario.text.toString()
                                    val ActividadMain = Intent(this, MainActivity::class.java)
                                    ActividadMain.putExtra("RegistroOk", "$UsuarioOk")
                                    startActivity(ActividadMain)

                                } else {
                                    showAlert()
                                }
                            }

                        }
                    }
                }
            }
        } catch (e: IOException) {
            claseFunciones.ttoas("Error al registrar usuario",this)
        }

    }

    //Funcion de alerta
    private fun showAlert()
    {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Error autentificando usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    //Funcion para chequear clave
    private fun chequeaClave(): Boolean
    {
        var check:Boolean = false
        if(txtRegistroClave.text.toString() ==  txtRegistroRepClave.text.toString())
        {
            check = true
        }
        return check
    }

    //funcion de registro vacio
    private fun registroVacio(): Boolean
    {
        var check:Boolean = false
        if (txtRegistroUsuario.text.isNotEmpty() && txtMailUsuario.text.isNotEmpty() &&
            txtRegistroClave.text.isNotEmpty() && txtRegistroRepClave.text.isNotEmpty())
        {
            check = true
        }
        return check
    }

    //funcion validar mail
    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun largoclave(): Boolean
    {
        var largo : Boolean = false
        if(txtRegistroClave.length() in 1..5)
        {
            largo = true
        }
        return largo
    }

}

