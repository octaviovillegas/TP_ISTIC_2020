package com.example.listadecompras

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listadecompras.datamodels.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    private val SUCCESS = 2000
    private val FAIL = 999
    private var registerSuccess = 0
    private var updateUser = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        auth = Firebase.auth
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val txtUsuario = findViewById<TextView>(R.id.txtUsuario)
        val txtPassword = findViewById<TextView>(R.id.txtPassword)
        val txtConfirmPass = findViewById<TextView>(R.id.txtConfirmPass)
        var txtEmail = findViewById<TextView>(R.id.txtEmail)

        btnRegister.setOnClickListener()
        {
            var userToFile = txtUsuario.text.toString().trim()
            var passToFile = txtPassword.text.toString().trim()
            var confirmPassToFile = txtConfirmPass.text.toString().trim()
            var emailToFile = txtEmail.text.toString().trim()

            if (validateForm(userToFile, passToFile, confirmPassToFile, emailToFile))
            {
                registerUser(emailToFile, passToFile)
                saveUserData(userToFile, emailToFile)
                ToastMessage("Registro exitoso!")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                //messageHandler()
                //messageHandler()
                /*if(registerUser(emailToFile,passToFile))
                {
                    updateUserData(userToFile)
                    saveUserData(userToFile,emailToFile)
                }

                */
            }
            registerSuccess = 0
            updateUser = 0
        }

    }

    private fun messageHandler()
    {
        when {
            registerSuccess == SUCCESS -> {
                ToastMessage("Registro exitoso!")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            registerSuccess == FAIL -> {
                ToastMessage("Registro fallido")
            }
        }
    }

    private fun registerUser(emailToFile: String, passToFile: String) //: Boolean
    {
        //var flag = false
        auth.createUserWithEmailAndPassword(emailToFile, passToFile)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Success", "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Fail", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
                if (!task.isSuccessful) {
                    Log.d("error log", "task error", task.exception)
                    //binding.status.setText(R.string.auth_failed)
                }
            }
        //return flag
    }

    private fun updateUserData(userToFile: String)
    {
        val user = auth.currentUser

        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(userToFile)
            .build()

        user?.updateProfile(profileUpdates)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    updateUser = SUCCESS
                }
            }
    }

    private fun saveUserData(user: String, email: String)
    {
        try {
            val dbRef = DBReference()
            val key = dbRef.child("users").push().key
            val userObj = User(user, email)
            val postValues = userObj.toMap()
            val childUpdates = HashMap<String, Any>()
            childUpdates["/users/$key"] = postValues
            dbRef.updateChildren(childUpdates)
            /*dbRef.push().setValue(userObj).addOnCompleteListener {
                ToastMessage("Guardado!")
            }*/
        }
        catch (ex: Throwable) {
            ToastMessage("Error: ${ex.message}")
        }
    }

    private fun validateForm(user: String, pass: String, passConfirm: String, email: String) : Boolean
    {
        var flag = true
        when {
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
        }
        return flag
    }

    private fun DBReference() : DatabaseReference
    {
        val dbRef =  FirebaseDatabase.getInstance().reference
        return dbRef
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun  updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null)
        {
            var user = auth.currentUser
            ToastMessage("Bienvenido ${user?.email.toString()}!")
            startActivity(Intent(this, MenuPrincipal::class.java))
            finish()
        }
    }

    private fun ToastMessage(message: String)
    {
        Toast.makeText(this, "${message}", Toast.LENGTH_LONG).show()
    }

}
