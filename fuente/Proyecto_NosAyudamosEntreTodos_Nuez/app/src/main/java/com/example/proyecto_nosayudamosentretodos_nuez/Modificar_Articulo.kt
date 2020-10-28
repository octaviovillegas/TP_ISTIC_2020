package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mis__articulos.*
import kotlinx.android.synthetic.main.activity_modificar__articulo.*

class Modificar_Articulo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar__articulo)

        val codigo = intent.getStringExtra("identificacion");
        val codigo_2 = codigo


        var codigo_3 = codigo_2.toInt()

            val admin = Base_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery(
                "select id,titulo,categoria,tipo,descripcion,localidad,codiPos,telefono from MisArticulos where id=$codigo_3",
                null
            )
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

                    lbl_modificar_titulo.setText(titulo)
                    lbl_modificar_categoria.setText(categoria)
                    lbl_modificar_tipo.setText(tipo)
                    lbl_modificar_descripcion.setText(descripcion)
                    lbl_modificar_localidad.setText(localidad)
                    lbl_modificar_codpos.setText(codiPos)
                    lbl_modificar_telefono.setText(telefono)


                } while (fila.moveToNext())

            }
            bd.close()

        btn_modificar_datos_articulo.setOnClickListener {

            actualizar_datos(codigo_3)

        }

        btn_volver_ModificarArticulo.setOnClickListener {

            val intent40: Intent = Intent(this, Mis_Articulos::class.java)

            startActivity(intent40)

            finish()

        }
    }

    fun actualizar_datos(id_pub:Int){

        try{

            val admin = Base_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase

            val registro = ContentValues()
            registro.put("titulo",lbl_modificar_titulo.text.toString())
            registro.put("categoria",lbl_modificar_categoria.text.toString())
            registro.put("tipo",lbl_modificar_tipo.text.toString())
            registro.put("descripcion",lbl_modificar_descripcion.text.toString())
            registro.put("localidad",lbl_modificar_localidad.text.toString())
            registro.put("codipos",lbl_modificar_codpos.text.toString())
            registro.put("telefono",lbl_modificar_telefono.text.toString())

            val cant =  bd.update("MisArticulos",registro,"id=$id_pub",null)
            bd.close()

            if(cant == 1){
                Toast.makeText(this, "la publicacion se actualizo con exito", Toast.LENGTH_SHORT).show()
                val intent30: Intent = Intent(this, Mis_Articulos::class.java)
                startActivity(intent30)
                finish()
            }

        }catch(e:Throwable){

            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }


    }


    }

