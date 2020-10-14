package com.example.ferretexapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    //var bienvenidoLabel: TextView? = null
    //var continuarLabel: TextView? = null
    //var nuevoUsuario: TextView? = null
    //var loginImageView: ImageView? = null
    //var usuarioTextField: TextInputLayout? = null
    //var contrasenaTextField: TextInputLayout? = null
    //var inicioSesion: MaterialButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginImageView = findViewById<ImageView>(R.id.loginImageView)
        val bienvenidoLabel = findViewById<TextView>(R.id.bienvenidoLabel)
        val continuarLabel = findViewById<TextView>(R.id.continuarLabel)
        //val usuarioTextField = findViewById<TextView>(R.id.usuarioTextField)
        //val contrasenaTextField = findViewById<TextView>(R.id.contrasenaTextField)
        val inicioSesion = findViewById<TextView>(R.id.inicioSesion)
        val nuevoUsuario = findViewById<TextView>(R.id.nuevoUsuario)
        val btnNuevoUsuario = findViewById<Button>(R.id.btnNuevoUsuario)


        val animacionParaArriba = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        loginImageView.animation = animacionParaArriba;
        bienvenidoLabel.animation = animacionParaArriba;
        continuarLabel.animation = animacionParaArriba;
        usuarioTextField.animation = animacionParaArriba;
        inicioSesion.animation = animacionParaArriba;
        nuevoUsuario.animation = animacionParaArriba;

        btnNuevoUsuario.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, Registro::class.java)



            //val pairs: Array<Pair<*, *>?> = arrayOfNulls(7)
            /*this.loginImageView.animation = logoImageTrans
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
            )*/
            //Código para ver si está la versión correcta
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val options = ActivityOptions.makeSceneTransitionAnimation(this@LoginActivity, *pairs)
                startActivity(intent, options.toBundle())
            } else {
                startActivity(intent)
                finish()
            }*/
        })
    }
}