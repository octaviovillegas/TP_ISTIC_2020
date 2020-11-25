package com.example.dinvercalculos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_spread.*
import java.io.IOException

class Spread : AppCompatActivity() {

    var valorCompra:Double = 0.00
    var valorVenta:Double = 0.00
    var resultadoSpreadPor:Double = 0.00
    var resultadoSpreadNum:Double = 0.00


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spread)

        val btnCalcSpread = findViewById<Button>(R.id.btnCalcSpread)

        btnCalcSpread.setOnClickListener {
            try {
            calcularSpreadPorc()
            calcularSpreadNum()
            }catch (e: IOException) {
                claseFunciones.ttoas("Revise los campos",this)
            }
        }

    }

    fun calcularSpreadPorc()
    {
        try {
            valorCompra = txtValorCompra.text.toString().toDouble()
            valorVenta = txtValorVenta.text.toString().toDouble()

            resultadoSpreadPor = Math.round((((valorCompra - valorVenta) / valorVenta) * 100) * 100.0) / 100.0

            txtSpreadPorc.text = resultadoSpreadPor.toString() + "%"

        }catch (e: IOException) {
            claseFunciones.ttoas("Revise los campos",this)
        }

    }

    fun calcularSpreadNum()
    {
        try {
            resultadoSpreadPor = Math.round(((txtValorCompra.text.toString().toDouble() - txtValorVenta.text.toString().toDouble())) * 100.0) / 100.0
            txtSpreadNum.text =  "$" + resultadoSpreadPor.toString()
        }catch (e: IOException) {
            claseFunciones.ttoas("Revise los campos",this)
        }
    }
}
