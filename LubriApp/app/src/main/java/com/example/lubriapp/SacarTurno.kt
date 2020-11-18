package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sacar_turno.*

class SacarTurno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sacar_turno)


                // guardo lo que ingreso el cliente en variables, para despues pasar esas variables

        BtenPreguntar.setOnClickListener {
            val intentoVolar = Intent(this, ConfirmarTurno::class.java)
            var dato1 :String = nombreCliente.toString()
            var dato2 :String = fechaCliente.toString()
            var dato3 :String = autoCliente.toString()
            var dato4 :String = servicioCliente.toString() // guardo lo que ingreso el cliente en variables, para despues pasar esas variables
            var dato5 :String = celularCliente.toString()
            var dato6 :String = horarioCliente.toString()
            intentoVolar.putExtra("Nombre", dato1)
            intentoVolar.putExtra("Fecha", dato2)
            intentoVolar.putExtra("Auto", dato3)
            intentoVolar.putExtra("Servicio", dato4)
            intentoVolar.putExtra("Celular", dato5)
            intentoVolar.putExtra("Horario", dato6)
            startActivity(intentoVolar)


            //val transportador : Bundle = Bundle()
            //transportador.putString("nombre", dato1; "fecha", dato2) // ;"fecha", dato2;  )


            Toast.makeText(this, "Recibirá la respuesta por whatsapp", Toast.LENGTH_LONG).show()
        }

    }
}