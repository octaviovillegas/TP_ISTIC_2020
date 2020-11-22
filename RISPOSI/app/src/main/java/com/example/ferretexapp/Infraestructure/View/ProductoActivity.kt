package com.example.ferretexapp.Infraestructure.View

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.ferretexapp.Infraestructure.DatabaseSqlLite
import com.example.ferretexapp.Infraestructure.Model.ImageController
import com.example.ferretexapp.Infraestructure.Model.Producto
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.activity_producto2.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivityForResult

class ProductoActivity : AppCompatActivity() {

    private lateinit var database: DatabaseSqlLite
    private lateinit var producto: Producto
    private lateinit var productoLiveData: LiveData<Producto>
    private val EDIT_ACTIVITY = 49

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto2)

        database = DatabaseSqlLite.getDatabase(this)
        val idProducto = intent.getIntExtra("id",0 )

        val imageUri = ImageController.getImageUri(this, idProducto.toLong())
        imagen.setImageURI(imageUri)

        productoLiveData = database.productosDao().get(idProducto)

        productoLiveData.observe(this, Observer {
            producto = it


            nombre_producto.text = producto.nombre
            precio_producto.text = "$${producto.precio}"
            detalles_producto.text = producto.descripcion
        })

        val btnEditProduct=find<Button>(R.id.btnEditProduct)
        val btnBorrarProduct = findViewById<Button>(R.id.btnBorrarProduct)

        btnBorrarProduct.setOnClickListener() {
            productoLiveData.removeObservers(this)

            CoroutineScope(Dispatchers.IO).launch {
                database.productosDao().delete(producto)
                ImageController.deleteImage(this@ProductoActivity, producto.idProducto.toLong())

                this@ProductoActivity.finish()
            }
        }

        btnEditProduct.setOnClickListener(){
            Log.d("Traigo Producto","Product${producto}")
            val intent = Intent(this, NuevoProducto::class.java)
            intent.putExtra("producto", producto)

            startActivityForResult(intent, EDIT_ACTIVITY)
            //Probando otra forma
            //Update()

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.producto_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.edit_item -> {
                val intent = Intent(this, NuevoProducto::class.java)
                intent.putExtra("producto", producto)
                //startActivity(intent)
                Log.w("StarActivity", "Actividad Editar")
                startActivityForResult(intent, EDIT_ACTIVITY)
                Log.w("StarActivity2", "actEdt")
            }

            R.id.delete_item -> {
                productoLiveData.removeObservers(this)

                CoroutineScope(Dispatchers.IO).launch {
                    database.productosDao().delete(producto)
                    ImageController.deleteImage(this@ProductoActivity, producto.idProducto.toLong())

                    this@ProductoActivity.finish()
                }

            }

        }
        return super.onOptionsItemSelected(item)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when{
            requestCode == EDIT_ACTIVITY && resultCode == Activity.RESULT_OK ->{
                imagen.setImageURI(data!!.data)
            }
        }


    }



    //Otra forma de Update
    /*fun Update(){
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd = admin.writableDatabase
        val registro = ContentValues()
        registro.put("descripcion", et2.text.toString())
        registro.put("precio", et3.text.toString())
        val cant = bd.update("articulos", registro, "codigo=${et1.text.toString()}", null)
        bd.close()
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "no existe un artículo con el código ingresado", Toast.LENGTH_SHORT).show()
    }*/


}

