package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_listado__usuarios.*
import kotlinx.android.synthetic.main.activity_mis__articulos.*

class Listado_Usuarios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado__usuarios)

        try {
            val listado = ArrayList<String>()
            val admin = Base_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select id,nombre,email from usuarios", null)
            if (fila.moveToFirst()) {

                do {
                    //val id: String = fila.getString(0)
                    val nombre: String = fila.getString(1)
                    val email: String = fila.getString(2)
                    listado.add("usuario:" + nombre + " " + "email:" + email)
                } while (fila.moveToNext())

            } else {
                Toast.makeText(this, "No hay usuarios", Toast.LENGTH_SHORT).show()
            }
            bd.close()

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listado)
            this.lsv_listado_usuarios.adapter = adapter

        }catch (e:Throwable)
        {
            Toast.makeText(this, "No usuarios ${e.message}",  Toast.LENGTH_SHORT).show()
        }


        btn_volver_ListaUsuarios.setOnClickListener {

            val intent60: Intent = Intent(this, Perfil_Usuario::class.java)

            startActivity(intent60)

            finish()
        }
    }
}
