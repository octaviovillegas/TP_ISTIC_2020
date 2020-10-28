package com.p4b0n.listviewsqlite

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setup()

    }

    private fun setup() {
        btnAcceder.setOnClickListener {
            if (etEmailL.text.isNotEmpty() && etPassL.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(etEmailL.text.toString(),etPassL.text.toString())
                    .addOnCompleteListener {

                        if (it.isSuccessful) {
                            showAcces(it.result?.user?.email ?: "")

                        } else { showAlert() }
                    }
            } else{ showAlert() }
        }

        btnRegistrarse.setOnClickListener {
            val unIntento = Intent(this, RegistroActivity::class.java)
            startActivity(unIntento)
        }

        btnSaltar.setOnClickListener {
            val unIntento = Intent(this, ListadoProducto::class.java)
            startActivity(unIntento)
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Compruebe usuario y contraseña e intente nuevamente...")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAcces(email: String) {
        val perfilIntent = Intent(this, ListadoProducto::class.java).apply {
            putExtra("email",email)
        }
        startActivity(perfilIntent)
    }
}
