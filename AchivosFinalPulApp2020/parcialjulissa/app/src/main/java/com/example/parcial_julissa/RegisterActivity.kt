package com.example.parcial_julissa

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import butterknife.ButterKnife
import com.example.parcial_julissa.datamodels.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val TAG = "SignupActivity"

    private lateinit var _nameText:EditText
    private lateinit var _dniText :EditText
    private lateinit var _direccionText:EditText
    private lateinit var _birthdayText:EditText
    private lateinit var _tarjetaText :EditText
    private lateinit var _emailText :EditText
    private lateinit var _passwordText :EditText
    private lateinit var _signupButton :Button
    private lateinit var _loginLink:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        ButterKnife.bind(this)

        auth=FirebaseAuth.getInstance()

        _emailText = findViewById(R.id.input_email)
        _loginLink= findViewById(R.id.link_login)
        _signupButton = findViewById(R.id.btn_signup)
        _tarjetaText = findViewById(R.id.input_tarjeta)
        _birthdayText = findViewById(R.id.input_birthday)
        _dniText = findViewById(R.id.input_dni)
        _nameText = findViewById(R.id.input_nombre)
        _direccionText = findViewById(R.id.input_direccion)
        _passwordText= findViewById(R.id.input_password)

        _signupButton.setOnClickListener {
            signup()
        }

        _loginLink.setOnClickListener {
            finish()
        }
    }

    fun signup() {
        Log.d(TAG, "Signup")
        if (!validate()) {
            onSignupFailed()
            return
        }
        _signupButton.isEnabled = false
        val progressDialog = ProgressDialog(
            this,
            android.R.style.ThemeOverlay_Material_Dark
        )

        progressDialog.setMessage("Registrando ...")
        progressDialog.show()
        val nombre = _nameText!!.text.toString()
        val email = _emailText!!.text.toString()
        val password = _passwordText!!.text.toString()
        val birthday = _birthdayText!!.text.toString()
        val direccion= _direccionText!!.text.toString()
        val tarjeta= _tarjetaText!!.text.toString()
        val dni= _dniText!!.text.toString()

        registrar(email,password, User(nombre, dni,tarjeta,birthday,direccion,0,email))

        Handler().postDelayed(
            { // On complete call either onSignupSuccess or onSignupFailed
                // depending on success
                onSignupSuccess()
                // onSignupFailed();
                progressDialog.dismiss()
            }, 3000
        )
    }


    fun onSignupSuccess() {
        _signupButton.isEnabled = true
        setResult(RESULT_OK, null)
        finish()
    }

    fun onSignupFailed() {
        Toast.makeText(baseContext, "Login failed", Toast.LENGTH_LONG).show()
        _signupButton.isEnabled = true
    }

    fun validate(): Boolean {
        var valid = true
        val name = _nameText!!.text.toString()
        val email = _emailText!!.text.toString()
        val password = _passwordText!!.text.toString()
        if (name.isEmpty() || name.length < 3) {
            _nameText!!.error = "at least 3 characters"
            valid = false
        } else {
            _nameText!!.error = null
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText!!.error = "ingrese un correo valido"
            valid = false
        } else {
            _emailText!!.error = null
        }
        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            _passwordText!!.error = "debe tener entre 4 & 10 characters"
            valid = false
        } else {
            _passwordText!!.error = null
        }
        return valid
    }
    private fun registrar(email: String, password:String,usuario: User) {
        if (email!="" && password!="") {
            Toast.makeText(this,"dentro del if",Toast.LENGTH_LONG).show()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    Log.w("Error Autenticaction", "Autentication")
                    if (task.isSuccessful) {
                        val user: FirebaseUser? = auth.currentUser
                        Log.d("dbref", "Referencia a Base de Datos")
                        grabar(usuario)

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

    private fun grabar(usuario: User){
        Log.w("Key Try", "Error fuera del Try")
        try {
            val dbref = DbReference()
            val key = dbref.child("Usuarios").push().key
            Log.w("Key","esta ${key}")
            val postValues = usuario.toMap()
            val childUpdates = HashMap<String,Any>()
            childUpdates["/Usuarios/$key"] = postValues
            dbref.updateChildren(childUpdates)
        }catch (ex:Throwable)
        {
            Log.w("Key Catch", "Error")
            Toast.makeText(this,"Error${ex.message}",Toast.LENGTH_LONG).show()
        }
    }
}