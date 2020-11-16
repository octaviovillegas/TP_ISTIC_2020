package com.example.ferretexapp.Infraestructure.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ferretexapp.Infraestructure.DatabaseSqlLite
import com.example.ferretexapp.Infraestructure.Model.Producto
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_nuevo_producto.*
import org.jetbrains.anko.doAsync

class NuevoProducto : AppCompatActivity() {

    private val  db = DatabaseSqlLite.getDatabase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_producto)

        guardar_btn.setOnClickListener {
            val nombre = name_et.text.toString()
            val precio = precio_et.text.toString().toDouble()
            val descripcion = descripcion_et.text.toString()

            val producto = Producto(nombre,precio,descripcion)

            doAsync {
                db.productosDao().insertAll(producto)

                runOnUiThread{
                    this@NuevoProducto.finish()
                }
            }


        }
    }
}
