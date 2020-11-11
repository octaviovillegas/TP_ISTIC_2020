package com.example.parcial_julissa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import android.app.ProgressDialog
import android.content.Intent
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private var TAG:String = "LoginActivity"
    private var REQUEST_SIGNUP = 0

    private lateinit var _emailText: EditText
    private lateinit var _passwordText: EditText
    private lateinit var _loginBtn:Button
    private lateinit var _signTextView:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth=FirebaseAuth.getInstance()
        _emailText= findViewById<EditText>(R.id.input_email)
        _passwordText = findViewById<EditText>(R.id.input_password)
        _loginBtn = findViewById<Button>(R.id.btn_login)
        _signTextView= findViewById<TextView>(R.id.link_signup)

        _signTextView.setOnClickListener {
            val intent1 = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent1, REQUEST_SIGNUP)
        }

        _loginBtn.setOnClickListener {
            _login()
            val intent2 = Intent(this, HomeActivity::class.java)
            startActivity(intent2)
       }
    }

    private fun _login() {
        Log.d(TAG, "Login")
        if (!validate()) {
            onLoginFailed()
            return
        }
        _loginBtn.isEnabled = false
        val progressDialog = ProgressDialog(
            this@LoginActivity,
            R.style.ThemeOverlay_AppCompat_Dark
        )
        progressDialog.setMessage("Iniciando Session...")
        progressDialog.show()

        val email = _emailText.text.toString()
        val password = _passwordText.text.toString()
        login(email, password)
        // TODO: Implement your own authentication logic here.
        Handler().postDelayed(
            { // On complete call either onLoginSuccess or onLoginFailed
                onLoginSuccess()
                 onLoginFailed();
                progressDialog.dismiss()
            }, 3000
        )
    }


    @Override
    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }

    private fun onLoginSuccess() {
        _loginBtn.isEnabled = true
        finish()
    }

    private fun onLoginFailed() {
        Toast.makeText(baseContext, "Login failed", Toast.LENGTH_LONG).show()
        _loginBtn.isEnabled = true
    }

    private fun validate():Boolean {
        var valid = true

        val email = _emailText.text.toString()
        val password = _passwordText.text.toString()

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.error = "Ingrese un correo valido!!!"
            valid = false
        } else {
            _emailText.error = null
        }

        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            _passwordText.error = "contraseña de 4 a 10 characteres"
            valid = false
        } else {
            _passwordText.error = null
        }
        return valid
    }


    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                val intent2 = Intent(this, HomeActivity::class.java)
                startActivity(intent2)
                this.finish()
            }
        }
    }


    private fun login(email: String,password:String){
        if (email!="" && password!="") {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user: FirebaseUser? = auth.currentUser
                        val intent2 = Intent(this, HomeActivity::class.java)
                        startActivity(intent2)
                        Toast.makeText(this, "Logueado a Ferre-Tex", Toast.LENGTH_LONG).show()
                    } else {
                        Log.w("Error", "${task.exception?.message}")
                        Toast.makeText(this, "Logueo Incorrecto", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}