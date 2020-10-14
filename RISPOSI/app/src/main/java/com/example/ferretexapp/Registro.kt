package com.example.ferretexapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_registro.*

class Registro : AppCompatActivity() {
    var bienvenidoLabel: TextView? = null
    var continuarLabel: TextView? = null
    var nuevoUsuario: TextView? = null
    var signUpImageView: ImageView? = null
    var usuarioTextField: TextInputLayout? = null
    var contrasenaTextField: TextInputLayout? = null
    var inicioSesion: MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        signUpImageView = findViewById(R.id.signUpImageView)
        bienvenidoLabel = findViewById(R.id.bienvenidoLabel)
        continuarLabel = findViewById(R.id.continuarLabel)
        usuarioTextField = findViewById(R.id.usuarioTextField)
        contrasenaTextField = findViewById(R.id.contrasenaTextField)
        inicioSesion = findViewById(R.id.inicioSesion)
        nuevoUsuario = findViewById(R.id.nuevoUsuario)
        val btnNuevoUsuario2 = findViewById<Button>(R.id.btnNuevoUsuario2)

        //val btnIngresar = findViewById(android.R.id.btnIngresar)

        //Importo al método cuando el usuario hace click en el botón nuevoUsuario
        btnNuevoUsuario2.setOnClickListener(View.OnClickListener { transitionBack() })
    }

    override fun onBackPressed() {
        transitionBack()
    }
    //Método para volver atras
    fun transitionBack() {
        val intent = Intent(this@Registro, LoginActivity::class.java)
        //Arreglo de las animaciones que se van a realizar
        val pairs: Array<Pair<*, *>?> = arrayOfNulls(7)
        pairs[0] =
            Pair<View?, String>(signUpImageView, "logoImageTrans")
        pairs[1] =
            Pair<View?, String>(bienvenidoLabel, "textTrans")
        pairs[2] = Pair<View?, String>(
            continuarLabel,
            "iniciaSesionTextTrans"
        )
        pairs[3] = Pair<View?, String>(
            usuarioSignUpTextField,
            "emailInputTextTrans"
        )
        pairs[4] = Pair<View?, String>(
            contrasenaTextField,
            "passwordInputTextTrans"
        )
        pairs[5] =
            Pair<View?, String>(inicioSesion, "buttonSignInTrans")
        pairs[6] =
            Pair<View?, String>(nuevoUsuario, "newUserTrans")
        //Código para verificar si se cuenta con la versión
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val options = ActivityOptions.makeSceneTransitionAnimation(this@SignUpActivity, *pairs)
            startActivity(intent, options.toBundle())
        } else {
            startActivity(intent)
            finish()
        }*/
    }
}
