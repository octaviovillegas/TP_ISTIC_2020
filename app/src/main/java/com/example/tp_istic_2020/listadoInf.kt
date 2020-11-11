package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listado_inf.*

class listadoInf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_inf)
        mostrarListado()

        btnAtras2.setOnClickListener {
            val intent: Intent = Intent(this, menuCRUD ::class.java)
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
            val fila = bd.rawQuery("select informe,nombre from informacion", null)
            if (fila.moveToFirst()) {
                do {

                    val informe: String = fila.getString(0)
                    val nombre: String = fila.getString(1)
                    listado.add("item: "+informe+" "+ "nombre: "+nombre+" \n")
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