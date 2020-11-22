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


        BtenPreguntar.setOnClickListener {
            val dato1 :String = nombreCliente.text.toString()
            val dato2 :String = fechaCliente.text.toString()
            val dato3 :String = horarioCliente.text.toString()
            val dato4 :String = autoCliente.text.toString() // guardo lo que ingreso el cliente en variables, para despues pasar esas variables
            val dato5 :String = servicioCliente.text.toString()
            val dato6 :String = celularCliente.text.toString()

            val intent = Intent() //hago un intent para que lo que se ingreso, lo mande por gmail a tapialescustomgarage@gmail.com
            intent.type = "text/plain"
            //intent.putExtra(Intent.EXTRA_TEXT, "Me llamo: ${nombreCliente}, La fecha que me conviene es el: ${fechaCliente}, a las: ${horarioCliente}, tengo un ${autoCliente}, que necesita ${servicioCliente}, mi celular es ${celularCliente}")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Pregunta por turno, enviar a tapialescustomgarage@gmail.com") //es el asunto del mail
            intent.putExtra(Intent.EXTRA_TEXT, "Me llamo: $dato1, La fecha que me conviene es el: $dato2, a las: $dato3, Tengo un: $dato4, que necesita: $dato5, Mi celular es: $dato6")
            intent.action = Intent.ACTION_SEND //le damos la accion de enviar al intent
            val chooseIntent = Intent.createChooser(intent, "Elija gmail, nuestro contaco es: tapialescustomgarage@gmail.com ")//creo otro intent que usa a iten, pero nos da las opciones para elegir con que compartir, si es gmail, facebook, etc
            startActivity(chooseIntent)


            if (nombreCliente.text.toString().isEmpty() or fechaCliente.text.toString().isEmpty() or autoCliente.text.toString().isEmpty() or servicioCliente.text.toString().isEmpty() or celularCliente.text.toString().isEmpty() or horarioCliente.text.toString().isEmpty())
            {
                Toast.makeText(this, "Campos vacios ", Toast.LENGTH_LONG).show()
            }
            /*
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

             */


            else
            {
                Toast.makeText(this, "Cargado con éxito, recibirá la respuesta por whatsapp", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "Enviar a tapialescustomgarage:gmail.com", Toast.LENGTH_LONG).show()
            }

        }

        BtnVolver.setOnClickListener {
            val intento = Intent(this,Cliente::class.java)
            startActivity(intento)
            finish()
        }

    }
}