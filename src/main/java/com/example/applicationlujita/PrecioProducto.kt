package com.example.applicationlujita

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_precio_producto.*

class PrecioProducto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precio_producto)

        button2Volver.setOnClickListener {

            val intent: Intent = Intent(this, CodigoQR::class.java)
            startActivity(intent)
            finish()
        }
    }
}
