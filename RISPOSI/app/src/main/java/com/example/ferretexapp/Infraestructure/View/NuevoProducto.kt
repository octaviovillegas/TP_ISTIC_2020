package com.example.ferretexapp.Infraestructure.View

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import com.example.ferretexapp.Infraestructure.DatabaseSqlLite
import com.example.ferretexapp.Infraestructure.Model.ImageController
import com.example.ferretexapp.Infraestructure.Model.Producto
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_nuevo_producto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.anko.find

class NuevoProducto : AppCompatActivity() {

    private val SELECT_ACTIVITY = 50
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_producto)

        //Definicion de los elementos para las animaciones
//===============================================================================================
        val imageSelectIv = findViewById<ImageView>(R.id.imageSelectIv)
        val guardar_btn=find<Button>(R.id.guardar_btn)

//==============================================================================================

//=================================================================================================
        //Animaciones
        val animacionParaArriba = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        val animacionParaAbajo=AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo)
        imageSelectIv.animation = animacionParaArriba;
        guardar_btn.animation = animacionParaArriba;

        name_et.animation=animacionParaAbajo
        precio_et.animation=animacionParaAbajo
        descripcion_et.animation=animacionParaAbajo

//=================================================================================================

        var idProducto: Int? = null
        if (intent.hasExtra("producto")) {
            val producto = intent.extras?.getSerializable("producto") as Producto
            name_et.setText(producto.nombre)
            precio_et.setText(producto.precio.toString())
            descripcion_et.setText(producto.descripcion)
            idProducto = producto.idProducto

            val imageUri = ImageController.getImageUri(this,idProducto.toLong())
            imageSelectIv.setImageURI(imageUri)
        }
        val db = DatabaseSqlLite.getDatabase(this)

        guardar_btn.setOnClickListener {
            val nombre = name_et.text.toString()
            val precio = precio_et.text.toString().toDouble()
            val descripcion = descripcion_et.text.toString()

            val producto = Producto(nombre, precio, descripcion, R.drawable.ic_launcher_background)


            if (idProducto != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    producto.idProducto = idProducto
                    db.productosDao().update(producto)

                    imageUri?.let {
                        val intent = Intent()
                        intent.data=it
                        setResult(Activity.RESULT_OK, intent)
                        ImageController.saveImage(this@NuevoProducto, idProducto.toLong(),it)
                    }

                    this@NuevoProducto.finish()
                }
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    val id = db.productosDao().insertAll(producto)[0]

                    imageUri?.let {
                        ImageController.saveImage(this@NuevoProducto, id,it)
                    }

                    this@NuevoProducto.finish()
                }

            }
        }

        imageSelectIv.setOnClickListener {
            ImageController.selectPhotoGallery(this, SELECT_ACTIVITY)

        }
    }
//Accion para que cargue la imagen cuando la seleccionamos
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when{
                requestCode==SELECT_ACTIVITY && resultCode == Activity.RESULT_OK -> {
                    imageUri = data!!.data

                    imageSelectIv.setImageURI(imageUri)
                }
        }
    }

}



/*
            doAsync {
                db.productosDao().insertAll(producto)

                runOnUiThread{
                    this@NuevoProducto.finish()
                }
            }

*/

