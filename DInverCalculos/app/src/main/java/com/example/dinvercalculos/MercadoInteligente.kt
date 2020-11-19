package com.example.dinvercalculos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.app.AlertDialog
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mercado_inteligente.*
import java.lang.reflect.MalformedParametersException

class MercadoInteligente : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercado_inteligente)

        val btnVolumen = findViewById<Button>(R.id.btnVolumen)
        val btnEMA = findViewById<Button>(R.id.btnEMA)
        val btnRSI = findViewById<Button>(R.id.btnRSI)

        val btnEjecutar = findViewById<Button>(R.id.btnEjecutar)

        btnVolumen.setOnClickListener {
            volumen()
        }
        btnEMA.setOnClickListener {
            ema()
        }
        btnRSI.setOnClickListener {
            rsi()
        }

        btnEjecutar.setOnClickListener {
            txtResultInteligente.text = "Riesgo de compra 20 %"
        }

    }

    //Funcion para el boton volumen
    fun volumen(){
        lateinit var mAlertButton: Button
        val  programming_lang = arrayOf("Creciendo - bajo","Descendente - bajo","Creciendo - Alto","Descendente - alto")
        var checkedItem = 1

        mAlertButton = findViewById(R.id.btnVolumen)
        mAlertButton.setOnClickListener {

            val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

            mAlertDialogBuilder.setTitle("Volumen")
            mAlertDialogBuilder.setIcon(R.mipmap.ic_launcher)
            mAlertDialogBuilder.setCancelable(false)

            mAlertDialogBuilder.setSingleChoiceItems(programming_lang, checkedItem) {dialog, which ->
                when (which){
                    which -> {
                        Toast.makeText(this@MercadoInteligente, programming_lang[which], Toast.LENGTH_LONG).show()
                    }
                }
            }
            mAlertDialogBuilder.setPositiveButton("Aceptar"){_, _->
                Toast.makeText(this@MercadoInteligente, "Volumen seleccionado", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNegativeButton("Borrar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "Seleccion borrada", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNeutralButton("Cancelar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "Accion cancelada", Toast.LENGTH_LONG).show()
            }
            val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()
        }
    }//Finaliza funcion volumen

    //Funcion para el boton EMA
    fun ema(){
        lateinit var mAlertButton: Button
        val  programming_lang = arrayOf("Debajo EMA DE 8","Sobre EMA DE 8","Debajo EMA DE 21","Sobre EMA DE 21")
        var checkedItem = 1

        mAlertButton = findViewById(R.id.btnEMA)
        mAlertButton.setOnClickListener {

            val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

            mAlertDialogBuilder.setTitle("EMA Exponencial")
            mAlertDialogBuilder.setIcon(R.mipmap.ic_launcher)
            mAlertDialogBuilder.setCancelable(false)

            mAlertDialogBuilder.setSingleChoiceItems(programming_lang, checkedItem) {dialog, which ->
                when (which){
                    which -> {
                        Toast.makeText(this@MercadoInteligente, programming_lang[which], Toast.LENGTH_LONG).show()
                    }
                }
            }
            mAlertDialogBuilder.setPositiveButton("Aceptar"){_, _->
                Toast.makeText(this@MercadoInteligente, "Volumen seleccionado", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNegativeButton("Borrar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "Seleccion borrada", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNeutralButton("Cancelar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "Accion cancelada", Toast.LENGTH_LONG).show()
            }
            val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()
        }
    }//Finaliza funcion EMA

    //Funcion para el boton RSI
    fun rsi(){
        lateinit var mAlertButton: Button
        val  programming_lang = arrayOf("Sobre compra","Sobre venta")
        var checkedItem = 1

        mAlertButton = findViewById(R.id.btnRSI)
        mAlertButton.setOnClickListener {

            val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

            mAlertDialogBuilder.setTitle("Indice de fuerza relativa")
            mAlertDialogBuilder.setIcon(R.mipmap.ic_launcher)
            mAlertDialogBuilder.setCancelable(false)

            mAlertDialogBuilder.setSingleChoiceItems(programming_lang, checkedItem) {dialog, which ->
                when (which){
                    which -> {
                        Toast.makeText(this@MercadoInteligente, programming_lang[which], Toast.LENGTH_LONG).show()
                    }
                }
            }
            mAlertDialogBuilder.setPositiveButton("Aceptar"){_, _->
                Toast.makeText(this@MercadoInteligente, "Volumen seleccionado", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNegativeButton("Borrar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "Seleccion borrada", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNeutralButton("Cancelar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "Accion cancelada", Toast.LENGTH_LONG).show()
            }
            val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()
        }
    }//Finaliza funcion RSI


}
