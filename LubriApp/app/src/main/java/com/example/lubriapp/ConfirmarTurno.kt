package com.example.lubriapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_confirmar_turno.*

class ConfirmarTurno : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_turno)

        //Esta activity solo la ven los empleados
        val objetoIntent: Intent=intent
        var Nombre = objetoIntent.getStringExtra("Nombre")
        textView13.text = "El cliente se llama $Nombre" //escribo lo que mostrara el textView

        var Fecha = objetoIntent.getStringExtra("Fecha")
        textView14.text = "Quiere el día $Fecha" //escribo lo que mostrara el textView

        var Hora = objetoIntent.getStringExtra("Horario") //recibo lo que manda SacarTurno
        textView15.text = "A las $Hora" //escribo lo que mostrara el textView

        var Auto = objetoIntent.getStringExtra("Auto") //recibo lo que manda SacarTurno
        textView16.text = "Es un $Auto" //escribo lo que mostrara el textView

        var Servicio = objetoIntent.getStringExtra("Servicio") //recibo lo que manda SacarTurno
        textView17.text = "El servicio es $Servicio" //escribo lo que mostrara el textView

        var Celular = objetoIntent.getStringExtra("Celular") //recibo lo que manda SacarTurno
        textView18.text = "Su número es $Celular"
    }
}