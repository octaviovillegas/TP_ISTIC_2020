package com.example.ferretexapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.Pair
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ferretexapp.DataModels.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro.*


class LoginActivity : AppCompatActivity() {
/*
===========================================================
    //Definiciones para las animaciones version 1
    //var bienvenidoLabel: TextView? = null
    //var continuarLabel: TextView? = null
    //var nuevoUsuario: TextView? = null
    //var loginImageView: ImageView? = null
    //var usuarioTextField: TextInputLayout? = null
    //var contrasenaTextField: TextInputLayout? = null
    //var inicioSesion: MaterialButton? = null
==============================================================
*/
//Definicion de componenetes para Firebase

    private lateinit var auth: FirebaseAuth
    private var user: FirebaseUser? = null
//========================================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

//Definicion de los elementos para las animaciones
//===============================================================================================
        val loginImageView = findViewById<ImageView>(R.id.loginImageView)
        val bienvenidoLabel = findViewById<TextView>(R.id.bienvenidoLabel)
        val continuarLabel = findViewById<TextView>(R.id.continuarLabel)
        //val usuarioTextField = findViewById<TextView>(R.id.usuarioTextField)
        //val contrasenaTextField = findViewById<TextView>(R.id.contrasenaTextField)
        val passwordLogin = findViewById<TextView>(R.id.passwordLogin)
        val nuevoUsuario = findViewById<TextView>(R.id.nuevoUsuario)
        //val btnNuevoUsuario = findViewById<Button>(R.id.btnNuevoUsuario)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val inicioSesion = findViewById<MaterialButton>(R.id.inicioSesion)
//=================================================================================================
        //Firebase Autentication Login Version 1
        /*
        //Setup
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setupLogin(email ?: "", provider ?: "")
         */
//=================================================================================================
        //Animaciones
        val animacionParaArriba = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        loginImageView.animation = animacionParaArriba;
        bienvenidoLabel.animation = animacionParaArriba;
        continuarLabel.animation = animacionParaArriba;
        usuarioTextField.animation = animacionParaArriba;
        inicioSesion.animation = animacionParaArriba;
        nuevoUsuario.animation = animacionParaArriba;
        passwordLogin.animation = animacionParaArriba;
        btnLogin.animation = animacionParaArriba;

//=================================================================================================
        //Eventos de lso botones
        inicioSesion.setOnClickListener() {
            val intent1 = Intent(this, Registro::class.java)
            startActivity(intent1)
        }
        btnLogin.setOnClickListener() {
            //setup()
        }
    }
}
//=================================================================================================
    //Funciones para Autenticar el Logueo
/*
    private fun setup(){
        //var name: String = nameEditText.text.toString()
        var email: String = emailEditText.text.toString()
        var password: String = passwordEditText.text.toString()
        //var confirmpassword: String = confirmPasswordEditText.text.toString()
        if (email!="" && password!="") {
            auth.signUpUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user: FirebaseUser? = auth.currentUser
                        grabar(name, email)
                    } else {
                        Log.w("Error", "${task.exception?.message}")
                    }
                }
        }
    }
    private fun DbReference(): DatabaseReference {
        val dbRef= FirebaseDatabase.getInstance().reference
        return dbRef
    }
    private fun grabar(name:String,email:String){
        try {
            val dbref = DbReference()
            val key = dbref.child("Usuarios").push().key
            val userObject = User(name, email)
            val postValues = userObject.toMap()
            val childUpdates = HashMap<String,Any> ()
            childUpdates["/Usuarios/$key"] = postValues
            dbref.updateChildren(childUpdates)
        }catch (ex:Throwable)
        {
            Toast.makeText(this,"Error${ex.message}", Toast.LENGTH_LONG).show()
        }
    }
}
*/
/*
//===============================================================================
//Animaciones con array list Version 1
            val pairs: Array<Pair<*, *>?> = arrayOfNulls(7)
            this.loginImageView.animation = logoImageTrans
            pairs[0] = Pair<View?, String>(
                loginImageView,
                "logoImageTrans"
            )
            pairs[1] = Pair<View?, String>(
                bienvenidoLabel,
                "textTrans"
            )
            pairs[2] = Pair<View?, String>(
                continuarLabel,
                "iniciaSesionTextTrans"
            )
            pairs[3] = Pair<View?, String>(
                usuarioTextField,
                "emailInputTextTrans"
            )
            pairs[4] = Pair<View?, String>(
                contrasenaTextField,
                "passwordInputTextTrans"
            )
            pairs[5] = Pair<View?, String>(
                inicioSesion,
                "buttonSignInTrans"
            )
            pairs[6] = Pair<View?, String>(
                nuevoUsuario,
                "newUserTrans"
            )
            //Código para ver si está la versión correcta
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val options = ActivityOptions.makeSceneTransitionAnimation(this@LoginActivity, *pairs)
                startActivity(intent, options.toBundle())
            } else {
                startActivity(intent)
                finish()
            }
        })
    }
}
//==============================================================================================
        //Función para loguearse Version 1
        private fun setupLogin(email: String, provider:String) {
            title = "Inicio"
            btnLogin.setOnClickListener({
                if (emailEditText.text.toString().isNotEmpty() && passwordEditText.text.toString().isNotEmpty()) {
                    FirebaseAuth.getInstance().SignInWithEmailAndPassword(
                        emailEditText.text.toString(),
                        passwordEditText.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email? = "", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
                }
            })
        }
//=================================================================================================
//Funciones de MEnsajes. Complemento de la Autenticacion-Logueo
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun showHome(email:String, provider: ProviderType){
        val homeIntent = Intent (this, LoginActivity::class.java).apply {
            putExtra("email",email)
            putExtra("provider",provider.name)
        }
        startActivity(homeIntent)
    }
}
*/