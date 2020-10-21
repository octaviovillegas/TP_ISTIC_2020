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

//Definicion de componenetes para Firebase
    private lateinit var auth: FirebaseAuth
    private var user: FirebaseUser? = null
//========================================================================
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Firebase Autentication
        auth=FirebaseAuth.getInstance()

//Definicion de los elementos para las animaciones
//===============================================================================================
        val loginImageView = findViewById<ImageView>(R.id.loginImageView)
        val bienvenidoLabelLogin = findViewById<TextView>(R.id.bienvenidoLabelLogin)
        val continuarLabelLogin = findViewById<TextView>(R.id.continuarLabelLogin)
        val olvidasteContra = findViewById<TextView>(R.id.olvidasteContra)
        val nuevoUsuarioLogin = findViewById<TextView>(R.id.nuevoUsuarioLogin)
//==============================================================================================
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val inicioSesion = findViewById<MaterialButton>(R.id.inicioSesion)
//=================================================================================================
        //Animaciones
        val animacionParaArriba = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        loginImageView.animation = animacionParaArriba;
        bienvenidoLabelLogin.animation = animacionParaArriba;
        continuarLabelLogin.animation = animacionParaArriba;
        olvidasteContra.animation=animacionParaArriba;
        nuevoUsuarioLogin.animation = animacionParaArriba;

        btnLogin.animation = animacionParaArriba;
        inicioSesion.animation = animacionParaArriba;
//=================================================================================================
        //Eventos de los botones
        inicioSesion.setOnClickListener() {
            val intent1 = Intent(this, Registro::class.java)
            startActivity(intent1)
        }
        btnLogin.setOnClickListener() {
            setup()
        }
    }
//=================================================================================================
    //Funciones para Autenticar el Logueo
    private fun setup(){
        //var name: String = nameEditText.text.toString()
        var email: String = emailEditTextLogin.text.toString()
        var password: String = passwordEditTextLogin.text.toString()
        //var confirmpassword: String = confirmPasswordEditText.text.toString()
        if (email!="" && password!="") {
            Log.w("if", "Dentro if")
            Toast.makeText(this,"Dentro del if",Toast.LENGTH_LONG).show()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user: FirebaseUser? = auth.currentUser
                        val intent2 = Intent(this, HomeActivity::class.java)
                        startActivity(intent2)
                    } else {
                        Log.w("Error", "${task.exception?.message}")
                        Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show()
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