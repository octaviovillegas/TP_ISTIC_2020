package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mis__articulos.*

class Mis_Articulos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis__articulos)

        val listado=ArrayList<String>()
        val Articulo_datos: ArrayList<Articulo> = ArrayList()
        val Articulos_simple=ArrayList<String>()


        try {

            val admin = Base_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select id,titulo,categoria,tipo,descripcion,localidad,codiPos,telefono from MisArticulos", null)
            if (fila.moveToFirst()) {

                do {
                    val id: Int = fila.getInt(0)
                    var titulo: String = fila.getString(1)
                    var categoria: String = fila.getString(2)
                    var tipo: String = fila.getString(3)
                    var descripcion: String = fila.getString(4)
                    var localidad: String = fila.getString(5)
                    var codiPos: String = fila.getString(6)
                    var telefono: String = fila.getString(7)

                    //listado.add(titulo + categoria + tipo + descripcion + localidad + codiPos + telefono)
                    Articulos_simple.add("id:" + id + " " + "titulo:" + titulo + " " + "localidad:" + localidad)


                    Articulo_datos.add(Articulo(id,titulo, categoria, tipo, descripcion, localidad, codiPos, telefono))

                } while (fila.moveToNext())

            } else {
                Toast.makeText(this, "No tienes publicaciones", Toast.LENGTH_SHORT).show()
            }
            bd.close()

            //val adaptadorSimple = adaptador_lsv_simple_publicacion(this, Articulo_datos)
          // lsv_mis_publicaciones.adapter = adaptadorSimple

            val adapter = Mis_Articulos_Adapter(this,Articulo_datos)
            lsv_mis_publicaciones.adapter=adapter

            //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Articulos_simple)
            //this.lsv_mis_publicaciones.adapter = adapter


        }catch (e:Throwable)
        {
            Toast.makeText(this, "Error:  ${e.message}",  Toast.LENGTH_SHORT).show()
        }



        lsv_mis_publicaciones.setOnItemClickListener { parent, view, position, id ->

            try {
                val intent8: Intent = Intent(this, Articulo_mas_datos::class.java)
                intent8.putExtra("MiArticulo", Articulo_datos[position])
                startActivity(intent8)

                finish()

            }catch (e:Throwable)
            {
                Toast.makeText(this, "Error:  ${e.message}",  Toast.LENGTH_SHORT).show()
            }


        }

        btn_volver_MisArticulos.setOnClickListener {

            val intent38: Intent = Intent(this, Perfil_Usuario::class.java)

            startActivity(intent38)

            finish()

        }

    }


}
