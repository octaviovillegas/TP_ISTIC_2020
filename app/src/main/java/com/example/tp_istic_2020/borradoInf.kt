package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_borrado_inf.*

class borradoInf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrado_inf)
        btnAtras4.setOnClickListener {
            val intent: Intent = Intent(this, menuCRUD ::class.java)
            startActivity(intent)
            finish()
        }
        btn_eliminar.setOnClickListener {

            if(lblNumeroItem.getText().isNotEmpty()) {
                val numero = (lblNumeroItem.getText().toString().toInt())
                borrandoItem(numero)
                lblNumeroItem.setText("")

            }else{
                Toast.makeText(this, "Ingrese item ", Toast.LENGTH_SHORT).show()
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
                val aux = bdd.delete("informacion", "nombre=$numero", null)
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