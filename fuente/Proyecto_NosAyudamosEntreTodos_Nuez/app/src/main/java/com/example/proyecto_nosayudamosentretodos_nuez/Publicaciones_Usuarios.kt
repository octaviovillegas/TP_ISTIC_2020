package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_publicaciones__usuarios.*

class Publicaciones_Usuarios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publicaciones__usuarios)

        val Publicaciones_usu: ArrayList<Articulo> = ArrayList()

        try{

        val admin = Base_Datos(this, "SqLite2020", null, 2)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery("select id,titulo,categoria,tipo,descripcion,localidad,codiPos,telefono from PublicacionesUsuarios", null)
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

                Publicaciones_usu.add(Articulo(id, titulo, categoria, tipo, descripcion, localidad, codiPos, telefono))

            } while (fila.moveToNext())

        } else {
            Toast.makeText(this, "No hay publicaciones", Toast.LENGTH_SHORT).show()
        }
        bd.close()

        val adapter = Listado_Pub_Usu_Adapter (this,Publicaciones_usu)
        lsv_listado_publicaciones.adapter=adapter

        }catch (e:Throwable)
        {
            Toast.makeText(this, "Error:  ${e.message}",  Toast.LENGTH_SHORT).show()
        }


        btn_volver_publicaciones.setOnClickListener {

            val intent16: Intent = Intent(this, Perfil_Usuario::class.java)

            startActivity(intent16)

            finish()

        }

        lsv_listado_publicaciones.setOnItemClickListener { parent, view, position, id ->

            try {
                val intent18: Intent = Intent(this, Publicaciones_Mas_Datos::class.java)
                intent18.putExtra("UsuPublicaciones", Publicaciones_usu[position])
                startActivity(intent18)
                finish()

                }catch (e:Throwable)
                {
                    Toast.makeText(this, "Error:  ${e.message}",  Toast.LENGTH_SHORT).show()
                }
        }

        btn_buscar_localidad.setOnClickListener {

            if(lbl_buscar_localidad.text.toString().isEmpty()){

                Toast.makeText(this, "Debes escribir una Localidad",  Toast.LENGTH_SHORT).show()
            }else {

                buscar_por_Localidad()

                lbl_buscar_localidad.setText("")

            }
        }

    }

    fun buscar_por_Localidad(){

        val Publicaciones_localidad: ArrayList<Articulo> = ArrayList()

        try {
            val art_localidad = lbl_buscar_localidad.getText().toString()

            val admin = Base_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery(
                "select id,titulo,categoria,tipo,descripcion,localidad,codiPos,telefono from PublicacionesUsuarios where localidad='$art_localidad'", null)
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

                    Publicaciones_localidad.add(Articulo(id, titulo, categoria, tipo, descripcion, localidad, codiPos, telefono
                        )
                    )

                } while (fila.moveToNext())

            } else {
                Toast.makeText(this, "No hay Articulos en esa localidad", Toast.LENGTH_SHORT).show()
            }
            bd.close()

            val adapter = Listado_Pub_Usu_Adapter(this, Publicaciones_localidad)
            lsv_listado_publicaciones.adapter = adapter

        }catch (e: Throwable){
            Toast.makeText(this, "Error al borrar  $e.message", Toast.LENGTH_SHORT).show()
        }

    }
}
