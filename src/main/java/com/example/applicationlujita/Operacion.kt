package com.example.applicationlujita

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.applicationlujita.productImage.MainActivityDos
import kotlinx.android.synthetic.main.activity_operacion.*

class Operacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operacion)


        ConsultarPreciosBtn.setOnClickListener {

                val intent: Intent = Intent(this, CodigoQR::class.java)
                startActivity(intent)
                finish()
            }

        cnsProductos.setOnClickListener {

            val intent: Intent = Intent(this, ListadoProductos::class.java)
            startActivity(intent)
            finish()
        }

        agrPrdBtn.setOnClickListener {

            val intent: Intent = Intent(this, MainActivityDos::class.java)
            startActivity(intent)
            finish()
        }
    }
}
