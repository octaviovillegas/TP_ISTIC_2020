package com.example.applicationlujita

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_autenticacion.*

class AutenticacionActivity : AppCompatActivity() {

    private val GOOGLE_SIGN_IN = 100

    //private val callbackManager = CallbackManager.Factory.create()//constante

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autenticacion)

        //Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        //Setup
        setup() //llamar a una funcion
        session()

    }

    override fun onStart() {
        super.onStart()
        authLayout.visibility = View.VISIBLE
    }
    private fun session() {

        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val email = prefs.getString("email", null)
        val provider = prefs.getString("provider", null)

        if (email != null && provider != null) {
            authLayout.visibility = View.INVISIBLE
            showHome(email, ProviderType.valueOf(provider))//si ya se inicio sesion, navega a las sig pantalla
        }

    }

    private fun setup() {
        title = "Autenticacion" //cambia el tirulo de la pantalla con propiedad title

        //accede al boton de registro
        signUpButton.setOnClickListener {//los datos introduciods sean correctos, mail y contraseña
            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {//si se completo satisfactoriamente
                        showHome(
                            it.result?.user?.email ?: "",
                            ProviderType.BASIC
                        )//condiciones en el caso q no exista mail se envie str vacio
                        //38 accede al mail del usuario q se kiere registrar
                    } else {// no correctamente y se ha producido un error mostrando un alert
                        showAlert()  //lama a la funcion

                    }
                }

            }
        }
        loginButton.setOnClickListener {
            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    emailEditText.text.toString(), passwordEditText.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }

                }


            }
        }
        googleButton.setOnClickListener {
            //Configuracion
            val googleConf =
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id)).requestEmail()
                    .build()

            //cliente de autenticacion de google, val constante
            val googleClient = GoogleSignIn.getClient(this, googleConf)
            googleClient.signOut()


            startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)

        }
        BtnSinRtro.setOnClickListener{

            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        /*facebookButton.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))

            LoginManager.getInstance().registerCallback(callbackManager, object :
                FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult?) {
                    result?.let {

                        val token = it.accessToken

                        val credential = FacebookAuthProvider.getCredential(token.token)//crea la credencial de face

                        FirebaseAuth.getInstance().signInWithCredential(credential)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    showHome(it.result?.user?.email ?: "", ProviderType.FACEBOOK)
                                } else {
                                    showAlert()
                                }
                            }
                        }
                    }

                override fun onCancel() {
                }

                override fun onError(error: FacebookException?) {
                    showAlert()
                }

            })
        }*/
    }
    private fun showAlert() {//alerta q muestra un error

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    //crea funcion q llama al mail autenticado tipo str y proveedor
    private fun showHome(email: String, provider: ProviderType ) {
        //esta funcion muestra la nueva pantalla, intent a la nueva pantalla y navegar a ella
        val homeIntent = Intent(this, LoginActivity::class.java).apply {
            putExtra("email", email)//parametro q le quiero pasar a la nueva pantalla
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)//navega a la nueva pantalla con homeIntent creado y parametros

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        //callbackManager.onActivityResult(requestCode, resultCode, data)//pasa parametros q llegan a la funcion de abajo
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GOOGLE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try{
                val account = task.getResult(ApiException::class.java)

                if (account != null) {

                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)

                    FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener{

                            if (it.isSuccessful) {
                                showHome(account.email ?: "", ProviderType.GOOGLE)
                            } else {
                                showAlert()

                            }
                        }

                }

            }catch (e: ApiException) {
                showAlert()
            }

        }
    }
}

