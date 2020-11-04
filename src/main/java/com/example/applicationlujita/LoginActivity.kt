package com.example.applicationlujita

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login.*


enum class ProviderType{
    BASIC,
    GOOGLE,
    //FACEBOOK
}

class LoginActivity : AppCompatActivity() {

    //referencia con una constante privada
    private val db = FirebaseFirestore.getInstance()//instancia conec a la BDD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Setup
        //setup necesita los parametros de la funcion de abajo
        val bundle = intent.extras//bundle para recuperar los parametros
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")

        //Guardado de datos del usuario autenticado, aunque la app pare los datos quedan guardados
        //val encargado de guardado de datos de tipo clave-valor
        val prefs =
            getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email", email)
        prefs.putString("provider", provider)
        prefs.apply()//asegura q se guardan los datos

    }

    private fun setup(email: String, provider: String) {//tiene q llegar los dos texView

        title = "Login"
        emailTextView.text =
            email//email textView, su proipedad texto y q actualice al mail ingresado
        providerTextView.text = provider

        //funcionalidad a boton cerrar sesion
        logOutButton.setOnClickListener {
            //Borrado de datos

            val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()

            //if (provider == ProviderType.FACEBOOK.name){
            //    LoginManager.getInstance().logOut()//cierra sesion en facebook
            //}

            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

        saveButton.setOnClickListener {

            db.collection("usuarios").document(email).set(
                hashMapOf("provider" to provider,
                    "DNI" to DNITextView.text.toString(),
                    "adress" to AddresTextView.text.toString(),
                    "phone" to phoneTextView.text.toString()))


        }

        getButton.setOnClickListener {

            db.collection("usuarios").document(email).get().addOnSuccessListener {
                DNITextView.setText(it.get("DNI") as String?)
                AddresTextView.setText(it.get("adress") as String?)
                phoneTextView.setText(it.get("phone") as String)
            }

        }

        deleteButton.setOnClickListener {

            db.collection("usuarios").document(email).delete()

        }
        btnContinuar.setOnClickListener {

            val intent: Intent = Intent(this, Operacion::class.java)
            startActivity(intent)
            finish()
        }
    }
}

