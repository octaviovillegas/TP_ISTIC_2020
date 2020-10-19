package com.example.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.listadecompras.Common_Functions.CommonFunctions.Companion.ToastMessage
import com.google.firebase.auth.FirebaseAuth

class MenuPrincipal : AppCompatActivity() {

    private lateinit var logOut: ImageView
    private lateinit var nuevaLstCompra: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        logOut = findViewById(R.id.imgLogOut)
        nuevaLstCompra = findViewById(R.id.btnComenzarCompra)

    }

    fun Logout(view: View) {
        ToastMessage("Hasta pronto!",this)
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this,MainActivity::class.java))
        finishAffinity()
    }

    fun goToCargaProducto(view: View){
        val intentCargaProducto = Intent(this,CargaProducto::class.java)
        startActivity(intentCargaProducto)
    }
}