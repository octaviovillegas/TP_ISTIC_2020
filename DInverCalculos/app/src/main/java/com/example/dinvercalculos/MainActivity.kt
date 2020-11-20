package com.example.dinvercalculos

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var mIsShowPass = false



    override fun onCreate(savedInstanceState: Bundle?) {

        //Thread.sleep(1000)
        setTheme(R.style.AppTheme)//Tema para splashscreem

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Funcion para converir a String una los editTexi
        fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

        //Si esta bien registrado entra aca
        val UsuarioOk  =intent.getStringExtra("RegistroOk");
        if(UsuarioOk != null)//Valido si el dato viene null
        {
            txtUsuarioLogin.text = UsuarioOk.toEditable()
            claseFunciones.ttoas("Registro exitoso!!!",this)
        }

        //GoogleAnalytic Event
        val analytics : FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("Message","Integracion de Firebases completa")
        analytics.logEvent("InitScreen",bundle)


        txtRegistroLogin.setOnClickListener{
            val registoIntent = Intent(this, Registro::class.java)
            startActivity(registoIntent)
        }

        val botonIngresar = findViewById<Button>(R.id.btnIngresar) //Declaracion para boton ingresar
        botonIngresar.setOnClickListener{//Boton ingresar
            //loginArchivo()
            val menuIntent = Intent(this, QuienSoy::class.java)
            startActivity(menuIntent)
        }

        ivShowHidePass.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }

        showPassword(mIsShowPass)

    }

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // To show the password
            txtClaveLogin.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.ic_hide_password_24dp)
        } else {
            // To hide the password
            txtClaveLogin.transformationMethod = PasswordTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.ic_show_password_24dp)
        }
        // Esta línea de código para colocar el puntero al final de la cadena de contraseña
        txtClaveLogin.setSelection(txtClaveLogin.text.toString().length)
    }

    private fun loginArchivo()
    {
        if (registroVacio()==false)
        {
            claseFunciones.ttoas("Ingrese usuario y clave",this)
            this.txtUsuarioLogin.error = "Ingrese un Mail"
            this.txtClaveLogin.error = "Ingrese la clave"
            this.txtUsuarioLogin.requestFocus()
            this.txtClaveLogin.requestFocus()
        }else {
            try {

                FirebaseAuth.getInstance().signInWithEmailAndPassword(txtUsuarioLogin.text.toString(),
                    txtClaveLogin.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful)
                    {
                        val usrlogin = txtUsuarioLogin.text
                        val menuIntent = Intent(this, QuienSoy::class.java)
                        menuIntent.putExtra("usuarioLogueado", "$usrlogin")
                        startActivity(menuIntent)
                    }else
                    {
                        claseFunciones.ttoas("Creenciales incorrectas",this)
                    }
                }

            } catch (e: IOException) {
                claseFunciones.ttoas("Error al ingresar",this)
            }
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

    //funcion de registro vacio
    private fun registroVacio(): Boolean
    {
        var check:Boolean = false
        if (txtUsuarioLogin.text.isNotEmpty() && txtClaveLogin.text.isNotEmpty())
        {
            check = true
        }
        return check
    }


}
