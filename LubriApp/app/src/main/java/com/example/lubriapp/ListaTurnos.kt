package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lista_turnos.*

class ListaTurnos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_turnos)
        mostrarListado()

        BtnVolver4.setOnClickListener {
            val intent: Intent = Intent(this, ABMServicios ::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun mostrarListado()
    {
        val listado=ArrayList<String>()
        try {
            val admin = bdd(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
           // val fila = bd.rawQuery("select informe,nombre from informacion", null)
            val fila = bd.rawQuery("select item , nombre, fecha, auto from servicios", null)
            if (fila.moveToFirst()) {
                do {

                    val informe: String = fila.getString(0)
                    val nombre: String = fila.getString(1)
                    listado.add("item: "+informe+" "+ "numero: "+nombre+" \n")
                } while (fila.moveToNext())
            } else{
                Toast.makeText(this, "Lista de items vacias",  Toast.LENGTH_SHORT).show()
            }
            bd.close()
            val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listado)
            this.lblListaItems.adapter=adapter
        }catch (e:Throwable)
        {
            Toast.makeText(this, "Sin items ${e.message}",  Toast.LENGTH_SHORT).show()
            e.message?.let { listado.add(it) }
        }

    }
}