package com.example.listadecompras

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.listadecompras.DataModels.Product
import org.w3c.dom.Text
import java.util.*

class DetalleProducto : AppCompatActivity() {

    private lateinit var detalle_prod_name: TextView
    private lateinit var detalle_prod_price: TextView
    private lateinit var detalle_prod_brand: TextView
    private lateinit var detalle_prod_cont_neto: TextView
    private lateinit var detalle_prod_lugar_compra: TextView
    private lateinit var detalle_prod_txt_count: TextView
    private lateinit var detalle_producto_precio_total: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)

        val detalleProducto: Product = intent.getSerializableExtra("detalleProducto") as Product
        
        detalle_prod_name = findViewById(R.id.detalle_producto_nombre)
        detalle_prod_price = findViewById(R.id.detalle_producto_precio)
        detalle_prod_brand = findViewById(R.id.detalle_producto_marca)
        detalle_prod_cont_neto = findViewById(R.id.detalle_producto_cont_neto)
        detalle_prod_lugar_compra = findViewById(R.id.detalle_producto_lugar_compra)
        detalle_prod_txt_count = findViewById(R.id.detalle_producto_cantidad)
        detalle_producto_precio_total = findViewById(R.id.detalle_producto_precio_total)

        detalle_prod_name.text = detalleProducto.name
        detalle_prod_price.text = "$${detalleProducto.price.toString()}"
        detalle_prod_brand.text = "Marca: ${detalleProducto.brand}"
        detalle_prod_cont_neto.text = "Contenido Neto: ${detalleProducto.contNeto}"
        detalle_prod_lugar_compra.text = "Comprado en: ${detalleProducto.buyPlace}"
        detalle_prod_txt_count.text = "x${detalleProducto.count.toString()}"
        var precioTotal = detalleProducto.count * detalleProducto.price!!.toInt()
        detalle_producto_precio_total.text = "$${precioTotal}"

    }
}