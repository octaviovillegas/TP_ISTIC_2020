package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_articulo_mas_datos.*

class Articulo_mas_datos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articulo_mas_datos)


        try {
            val MiArticulo = intent.getSerializableExtra("MiArticulo") as Articulo

            var id_mi_articulo = MiArticulo.id
            lbl_titulo_detalle.text =  MiArticulo.titulo
            lbl_categoria_detalle.text = MiArticulo.categoria
            lbl_tipo_detalle.text = MiArticulo.tipo
            lbl_descripcion_detalle.text = MiArticulo.descripcion
            lbl_localidad_detalle.text = MiArticulo.localidad
            lbl_codigoPost_detalle.text = MiArticulo.codiPos
            lbl_telefono_detalle.text = MiArticulo.telefono
            lbl_id_detalle.text = MiArticulo.id.toString() // agregue el toString por las dudas

            if (id_mi_articulo == 1) {
                imageView11.setImageResource(R.drawable.control_xbox)
            }
            if (id_mi_articulo == 2) {
                imageView11.setImageResource(R.drawable.pelota)
            }

        }catch (e:Throwable)
        {
           Toast.makeText(this, "Error.:  ${e.message}",  Toast.LENGTH_SHORT).show()
        }



        btn_borrar_publicacion.setOnClickListener {

            if ( lbl_borrar_modificar_pub.text.toString() != this.lbl_id_detalle.text.toString()){

                Toast.makeText(this, " No existe un articulo con ese codigo",  Toast.LENGTH_SHORT).show()


            }else {

                val cod = (lbl_borrar_modificar_pub.getText().toString().toInt())
                borrar_publicacion(cod)
                lbl_borrar_modificar_pub.setText(" ")
            }

        }

        btn_modificar_publicacion.setOnClickListener {

            if ( lbl_borrar_modificar_pub.text.toString() != this.lbl_id_detalle.text.toString()){

                Toast.makeText(this, " No existe un articulo con ese codigo",  Toast.LENGTH_SHORT).show()


            }else {

                val Cod_Publicacion = lbl_borrar_modificar_pub.getText().toString()
                val intent25: Intent = Intent(this, Modificar_Articulo::class.java)
                intent25.putExtra("identificacion", Cod_Publicacion)
                startActivity(intent25)

                finish()
            }

        }

        btn_volver_articulosMasdatos.setOnClickListener {

            val intent45: Intent = Intent(this, Mis_Articulos::class.java)

            startActivity(intent45)

            finish()
        }

    }

    private fun borrar_publicacion(cod_borrar: Int)
    {

        if (cod_borrar > 0 && lbl_borrar_modificar_pub.toString().isNotEmpty())
        {
            try {
                val admin = Base_Datos(this,"SqLite2020", null, 2)
                val bd = admin.writableDatabase
                val cant = bd.delete("MisArticulos", "id=$cod_borrar", null)
                if (cant == 1){

                    Toast.makeText(this, "La publicacion se borro con exito",  Toast.LENGTH_SHORT).show()
                    val intent8: Intent = Intent(this, Mis_Articulos::class.java)
                    startActivity(intent8)

                    finish()
                }

                bd.close()
            }catch (e: Throwable){
                Toast.makeText(this, "Error al borrar  $e.message", Toast.LENGTH_SHORT).show()
            }
        }
    }

}


