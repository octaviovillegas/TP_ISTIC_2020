package com.example.ferretexapp.Infraestructure.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ferretexapp.Infraestructure.DatabaseSqlLite
import com.example.ferretexapp.Infraestructure.Model.ImageController
import com.example.ferretexapp.Infraestructure.Model.Producto
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_nuevo_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevoProducto : AppCompatActivity() {

    private val SELECT_ACTIVITY = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_producto)

        var idProducto: Int? = null
        if (intent.hasExtra("producto")) {
            val producto = intent.extras?.getSerializable("productos") as Producto
            name_et.setText(producto.nombre)
            precio_et.setText(producto.precio.toString())
            descripcion_et.setText(producto.descripcion)
            idProducto = producto.idProducto
        }
        val db = DatabaseSqlLite.getDatabase(this)

        guardar_btn.setOnClickListener {
            val nombre = name_et.text.toString()
            val precio = precio_et.text.toString().toDouble()
            val descripcion = descripcion_et.text.toString()

            val producto = Producto(nombre, precio, descripcion, R.drawable.ic_launcher_background)


            if (idProducto != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    db.productosDao().update(producto)
                    this@NuevoProducto.finish()
                }
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    db.productosDao().insertAll(producto)
                    this@NuevoProducto.finish()
                }

            }
        }

        imageSelectIv.setOnClickListener {
            ImageController.selectPhotoGallery(this, SELECT_ACTIVITY)

        }
    }
/*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when{

        }
    }
*/
}



/*
            doAsync {
                db.productosDao().insertAll(producto)

                runOnUiThread{
                    this@NuevoProducto.finish()
                }
            }

*/

