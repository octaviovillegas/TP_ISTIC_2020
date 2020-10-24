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
import java.io.IOException

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

        val btnMenu = findViewById<Button>(R.id.btnMenu)
        btnMenu.setOnClickListener {
            val MenuIntent = Intent(this, Menu::class.java)
            startActivity(MenuIntent)
        }

        val btnSobreApp = findViewById<Button>(R.id.btnSobreApp)
        btnSobreApp.setOnClickListener {
            fSobreLaApp()
        }

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

    private fun fSobreLaApp()//Funcion sobre la app
    {
        try {
            val btnBorrarDialogBuilder = AlertDialog.Builder(this@QuienSoy) //Dialogo para sobre la app
            btnBorrarDialogBuilder.setTitle("Sobre la App")
            btnBorrarDialogBuilder.setIcon(R.mipmap.ic_launcher)
            btnBorrarDialogBuilder.setMessage("Aplicacion dedicada a calculos de inversion. No encontrara recomendaciones." +
                    "Es usted quien debe analizar y tomar sus deciciones de inversion.")
            btnBorrarDialogBuilder.setCancelable(false)

            btnBorrarDialogBuilder.setNegativeButton("Entiendo") { _, _ ->
                Toast.makeText(this, "Gracias por entender..",Toast.LENGTH_SHORT).show()
            }
            val btnBorrarDialog = btnBorrarDialogBuilder.create()
            btnBorrarDialog.show()

        }catch (e: IOException) {
            claseFunciones.ttoas("Error",this)
        }
    }
}