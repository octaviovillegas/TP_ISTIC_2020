package com.example.listadecompras

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.listadecompras.Common_Functions.CommonFunctions
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.DBReference
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.TAG
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.ToastMessage
import com.example.listadecompras.Common_Functions.DataBaseFunctions.Companion.saveUserCloudFirestore
import com.example.listadecompras.Common_Functions.DataBaseFunctions.Companion.saveUserRealtimeDatabase
import com.example.listadecompras.DataModels.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore


class Registro : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var progressBar: ProgressBar
    private lateinit var txtUsuario: TextView
    private lateinit var txtPassword: TextView
    private lateinit var txtConfirmPass: TextView
    private lateinit var txtEmail: TextView
    private lateinit var txtNombre: TextView
    private lateinit var txtTelefono: TextView
    private lateinit var db: FirebaseFirestore
    private var user: FirebaseUser? = null
    private val SUCCESS = 2000
    private val FAIL = 999
    private var EMAIL_EXIST = "The email address is already in use by another account."
    private var registerResult = 0
    private var updateUser = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        auth = FirebaseAuth.getInstance()
        user = auth.currentUser
        db = FirebaseFirestore.getInstance()


        progressBar = findViewById(R.id.progressBar)

        txtUsuario = findViewById(R.id.txtUsuario)
        txtPassword = findViewById(R.id.txtPassword)
        txtConfirmPass = findViewById(R.id.txtConfirmPass)
        txtEmail = findViewById(R.id.txtEmail)
        txtNombre = findViewById(R.id.txtNombre)
        txtTelefono = findViewById(R.id.txtTelefono)

    }

    fun register(view: View){
        createAccount()
    }

    private fun createAccount(){
        val userToFile:String = txtUsuario.text.toString().trim()
        val passToFile:String = txtPassword.text.toString().trim()
        val confirmPassToFile:String = txtConfirmPass.text.toString().trim()
        val emailToFile:String = txtEmail.text.toString().trim()
        val telefonoToFile:String = txtTelefono.text.toString().trim()
        val nombreToFile:String = txtNombre.text.toString().trim()

        if (validateForm(nombreToFile, userToFile, passToFile, confirmPassToFile, emailToFile, telefonoToFile)){

            progressBar.visibility = View.VISIBLE
            auth.createUserWithEmailAndPassword(emailToFile, passToFile)
                .addOnCompleteListener(this){ task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user:FirebaseUser? = auth.currentUser
                        verifyEmail(user)
                        saveUserRealtimeDatabase(nombreToFile, userToFile, emailToFile, telefonoToFile,this)
                        updateUI(user)
                        saveUserCloudFirestore(nombreToFile, userToFile, emailToFile, telefonoToFile, user?.uid)
                        registerResult = SUCCESS
                        messageHandler(registerResult.toString())
                        action()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("CreateFail", "${task.exception?.message}", task.exception)
                        registerResult = FAIL
                        messageHandler(task.exception?.message)
                        updateUI(null)
                        progressBar.visibility = View.GONE
                    }
            }
        }
    }

    private fun verifyEmail(user: FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){ task->
                if(task.isComplete){
                    CommonFunctions.ToastMessage("Correo de verificacion enviado", this)
                }
                else{
                    CommonFunctions.ToastMessage("Error al enviar correo de verificacion", this)
                }
            }
    }

    private fun action(){
        var loginIntent = Intent(this, MainActivity::class.java)
        startActivity(loginIntent)
        finish()
    }

    private fun validateForm(
        name: String,
        user: String,
        pass: String,
        passConfirm: String,
        email: String,
        phone: String
    ) : Boolean{
        var flag = true
        when {
            name.isEmpty() -> {
                this.txtNombre.error = "Debes ingresar un nombre"
                this.txtNombre.requestFocus()
                flag = false
            }
            user.isEmpty() -> {
                this.txtUsuario.error = "Debes ingresar un usuario"
                this.txtUsuario.requestFocus()
                flag = false
            }
            (pass.length in 1..5)  -> {
                this.txtPassword.error = "Debe tener al menos 6 caracteres"
                this.txtPassword.requestFocus()
                flag = false
            }
            pass.isEmpty() -> {
                this.txtPassword.error = "Debes ingresar una contraseña"
                this.txtPassword.requestFocus()
                flag = false
            }
            passConfirm.isEmpty() -> {
                this.txtConfirmPass.error = "Debes ingresar una contraseña"
                this.txtConfirmPass.requestFocus()
                flag = false
            }
            pass != passConfirm -> {
                this.txtPassword.error = "Las contraseñas deben coincidir"
                this.txtConfirmPass.error = "Las contraseñas deben coincidir"
                this.txtPassword.requestFocus()
                flag = false
            }
            email.isEmpty() -> {
                this.txtEmail.error = "Debes ingresar un email"
                this.txtEmail.requestFocus()
                flag = false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                this.txtEmail.error = "Ingresa un mail valido"
                this.txtEmail.requestFocus()
                flag = false
            }
            phone.isEmpty() -> {
                this.txtTelefono.error = "Debes ingresar un telefono"
                this.txtTelefono.requestFocus()
                flag = false
            }
        }
        return flag
    }

    private fun messageHandler(exceptionMessage: String?){
        when (registerResult) {
            SUCCESS -> {
                ToastMessage("Registro exitoso!", this)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            FAIL -> {
                if (exceptionMessage == EMAIL_EXIST) {
                    ToastMessage("El mail ya esta registrado", this)
                }
                ToastMessage("Registro fallido!", this)
            }
        }
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            var user = auth?.currentUser
            user?.let {
                val name = user.displayName
                val email = user.email
                val uid = user.uid
            }
        }
    }
}
