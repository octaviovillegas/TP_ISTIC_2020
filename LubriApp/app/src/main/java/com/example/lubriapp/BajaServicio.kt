package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_baja_servicio.*

class BajaServicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baja_servicio)

        BtnVolver3.setOnClickListener {
            val intent: Intent = Intent(this, ABMServicios ::class.java)
            startActivity(intent)
            finish()
        }

        BtnEliminar2.setOnClickListener {

            if(lblNumeroItem.getText().isNotEmpty()) {
                val numero = (lblNumeroItem.getText().toString().toInt())
                borrandoItem(numero)
                lblNumeroItem.setText("")

            }else{
                Toast.makeText(this, "Ingrese item ", Toast.LENGTH_SHORT).show() //si el item si esta vacio, muestra el toast para que ingrese un numero
            }
        }
    }
    private fun borrandoItem(numero: Int)
    {

        if ( lblNumeroItem.toString().isNotEmpty())
        {
            try {
                val admin = bdd(this,"SqLite2020", null, 2)
                val bdd = admin.writableDatabase
                val aux = bdd.delete("servicios", "item=$numero", null)
                if (aux == 1){
                    Toast.makeText(this, "Se borró el item = $numero", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Item inexistente", Toast.LENGTH_SHORT).show()
                }
                bdd.close()
            }catch (e: Throwable){
                Toast.makeText(this, "Error  $e.message", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Campo vacio ", Toast.LENGTH_SHORT).show()
        }
    }
}