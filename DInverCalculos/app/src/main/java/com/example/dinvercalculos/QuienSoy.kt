package com.example.dinvercalculos

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_quien_soy.*

class QuienSoy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quien_soy)

        val usrlogin=intent.getStringExtra("usuarioLogueado");
        if(usrlogin == null)//Valido si el dato viene null
        {
            claseFunciones.ttoas("Bienvenido",this)
        }else {
            claseFunciones.ttoas("Bienvenido $usrlogin",this)
        }
/*
        val btnContador = findViewById<Button>(R.id.btnContador)
        btnContador.setOnClickListener {
            val ContadorIntent = Intent(this, Contador::class.java)
            startActivity(ContadorIntent)
        }

        val btnNumSec = findViewById<Button>(R.id.btnNumSec)
        btnNumSec.setOnClickListener {
            val NumeSecretIntent = Intent(this, NumeroSecreto::class.java)
            startActivity(NumeSecretIntent)
        }
*/
        lblLegajo.setOnClickListener {
            claseFunciones.ttoas("Numero de Legajo",this)
        }

        val Salir = findViewById<ImageView>(R.id.btnOut)
        Salir.setOnClickListener{
            salir()
        }
    }

    //Funcion para salir de la app
    private fun salir(){
        val btnsalir = AlertDialog.Builder(this@QuienSoy) //Dialogo para salir
        btnsalir.setTitle("Salir")
        btnsalir.setIcon(R.mipmap.ic_launcher)
        btnsalir.setMessage("¿Esta seguro que desea salir?")
        btnsalir.setCancelable(false)
        btnsalir.setPositiveButton("Si") {_,_->
            FirebaseAuth.getInstance().signOut()
            val ActividadMail = Intent(this, MainActivity::class.java)
            //finish()
            //Cierra todas las actividades de la cola
            finishAffinity()
            startActivity(ActividadMail)
        }
        btnsalir.setNegativeButton("No") { _, _ ->
            Toast.makeText(this, "Indico No...",Toast.LENGTH_SHORT).show()
        }
        btnsalir.setNeutralButton("Cancel") { _, _ ->
            Toast.makeText(this, "Accion Cancelada..",Toast.LENGTH_SHORT).show()
        }
        val btnBorrarDialog = btnsalir.create()
        btnBorrarDialog.show()
    }
}