package com.example.androidretrofitapi

import android.accessibilityservice.GestureDescription
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.androidretrofitapi.Interfaces.ProductoAPI
import com.example.androidretrofitapi.models.Producto
import com.google.gson.internal.GsonBuildConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtCodigo = findViewById<EditText>(R.id.edtCodigo)
        val tvNombre = findViewById<TextView>(R.id.tvNombre)
        val tvDescripcion = findViewById<TextView>(R.id.tvDescripcion)
        val tvPrecio = findViewById<TextView>(R.id.tvPrecio)
        val imgProducto = findViewById<ImageView>(R.id.imgProducto)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)

        btnBuscar.setOnClickListener(){
            fun onClick(v: View?) {
                find(edtCodigo.getText().toString())
            }
        }
    }

    private fun find(codigo: String) {
        val retrofit = Retrofit.Builder().baseUrl("https://localhost:44348")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val productoAPI: ProductoAPI = retrofit.create(ProductoAPI::class.java)
        var callproductoAPI: Call<Producto?>
        val Callback<Producto>(){

        }
        /*
        val retrofit: Retrofit = GestureDescription.Builder().baseUrl("http://192.168.0.205:8081/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val productoAPI: ProductoAPI = retrofit.create(ProductoAPI::class.java)
        var callproductoAPI: Call<Producto?>
        find(codigo)
        Call.enqueue(object : Callback<Producto>) {
            fun onResponse(
                call: Call<Producto?>?,
                response: Response<Producto?>
            ) {
                try {
                    if (response.isSuccessful()) {
                        val p: Producto = response.body()
                        val URL_IMG =
                            "http://192.168.0.205:8081/img/" + p.get(pro_codigo).toString() + ".jpg"
                        tvNombre.setText(p.get(pro_nombre))
                        tvDescripcion.setText(p.get(pro_precio).toString())
                        Glide.with(getApplication()).load(URL_IMG).into(imgProducto)
                    }
                } catch (ex: Exception) {
                    Toast.makeText(this@MainActivity, ex.message, Toast.LENGTH_SHORT).show()
                }
            }

            fun onFailure(call: Call<Producto?>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Error de conexión", Toast.LENGTH_SHORT).show()
            }
        })*/
    }
}