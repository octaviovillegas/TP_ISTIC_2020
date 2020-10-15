package com.p4b0n.productstorage

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*


class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        //Analitycs events
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("Mensaje","Estamos adentro...")
        analytics.logEvent("Iniciando",bundle)

        //Setup
        setup()
    }

    private fun setup() {
        btnActPerf.setOnClickListener {
            if (etEmail.text.isNotEmpty() && etPass.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(etEmail.text.toString(),etPass.text.toString())
                    .addOnCompleteListener {

                        if (it.isSuccessful) {
                            showLogin(it.result?.user?.email ?: "")

                        } else { showAlert() }
                    }
            } else{ showAlert() }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Falló el registro, intente nuevamente...")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showLogin(email: String) {
        val loginIntent = Intent(this,LoginActivity::class.java).apply {
            putExtra("email",email)
        }
        startActivity(loginIntent)
    }
}
