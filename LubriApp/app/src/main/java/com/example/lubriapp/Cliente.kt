package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cliente.*

class Cliente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        try {
            BtnProduc.setOnClickListener {
                val intento = Intent(this, Productos::class.java)
                startActivity(intento)
            }
        } catch (ex:Throwable)
        {
            Toast.makeText(this, "Error reparable ", Toast.LENGTH_LONG).show()
        }


        BtnTurno.setOnClickListener{
            val intento = Intent(this, SacarTurno::class.java)
            startActivity(intento)
        }
    }
}