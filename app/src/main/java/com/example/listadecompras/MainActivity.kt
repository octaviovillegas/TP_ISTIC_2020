package com.example.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val AUTH_REQUEST_CODE = 2000
    private var user : FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val txtEmailLogIn = findViewById<TextView>(R.id.txtEmailLogIn)
        val txtPass = findViewById<TextView>(R.id.txtPass)

        btnLogin.setOnClickListener()
        {
            if (validateForm()) {logon()}
        }

        btnSignUp.setOnClickListener()
        {
            var registerIntent = Intent(this, Registro::class.java)
            startActivity(registerIntent)
        }

    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null)
        {
            var user = auth.currentUser
            user?.let {
                val name = user.displayName
                val email = user.email
            }
            ToastMessage("Bienvenido ${user?.email.toString()}!")
            startActivity(Intent(this,MenuPrincipal::class.java))
            finish()
        }
    }

    private fun logon()
    {
        var email = this.txtEmailLogIn.text.toString().trim()
        var pass = this.txtPass.text.toString().trim()
        auth.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    ToastMessage("Mail no registrado")
                    updateUI(null)
                }
            }
    }

    private fun validateForm() : Boolean
    {
        var email = this.txtEmailLogIn.text.toString().trim()
        var pass = this.txtPass.text.toString().trim()
        var flag = true
        when {
            email.isEmpty() -> {
                this.txtEmailLogIn.error = "Debes ingresar un email"
                this.txtEmailLogIn.requestFocus()
                flag = false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                this.txtEmailLogIn.error = "Ingresa un mail valido"
                this.txtEmailLogIn.requestFocus()
                flag = false
            }
            (pass.length in 1..5)  -> {
                this.txtPass.error = "Debe tener al menos 6 caracteres"
                this.txtPass.requestFocus()
                flag = false
            }
            pass.isEmpty() -> {
                this.txtPass.error = "Debes ingresar una contraseña"
                this.txtPass.requestFocus()
                flag = false
            }
        }
        return flag
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun ToastMessage(message: String)
    {
        Toast.makeText(this,"${message}", Toast.LENGTH_LONG).show()
    }
}