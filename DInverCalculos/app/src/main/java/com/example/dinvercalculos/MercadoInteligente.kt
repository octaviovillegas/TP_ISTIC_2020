package com.example.dinvercalculos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.app.AlertDialog
import android.view.View
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mercado_inteligente.*
import java.lang.reflect.MalformedParametersException

class MercadoInteligente : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercado_inteligente)


        val btnEjecutar = findViewById<Button>(R.id.btnEjecutar)


        btnEjecutar.setOnClickListener {
            txtResultInteligente.text = "Riesgo de compra 20 %"
        }

    }

    //Funcion para el boton volumen
    fun volumen(view : View){

        val  programming_lang = arrayOf("Creciendo - bajo","Descendente - bajo","Creciendo - Alto","Descendente - alto")
        var checkedItem = -1

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
                Toast.makeText(this@MercadoInteligente, "Volumen borrada", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNeutralButton("Cancelar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "Volumen cancelada", Toast.LENGTH_LONG).show()
            }
            val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()

    }//Finaliza funcion volumen

    //Funcion para el boton EMA
    fun ema(view : View){

        val  programming_lang = arrayOf("Debajo EMA DE 8","Sobre EMA DE 8","Debajo EMA DE 21","Sobre EMA DE 21",
            "Debajo EMA DE 50","Sobre EMA DE 50","Debajo EMA DE 200","Sobre EMA DE 200",
            "Cruce dorado!!!","Cruce peligroso")
        var checked_items = booleanArrayOf(false,false,false,false,false,false,false,false,false,false)

            val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

            mAlertDialogBuilder.setTitle("EMA Exponencial")
            mAlertDialogBuilder.setIcon(R.mipmap.ic_launcher)
            mAlertDialogBuilder.setCancelable(false)

            mAlertDialogBuilder.setMultiChoiceItems(programming_lang,checked_items) { dialog, which, isChecked ->
                when(which){
                    which -> {
                        Toast.makeText(this@MercadoInteligente, programming_lang[which], Toast.LENGTH_LONG).show()
                    }
                }
            }
            mAlertDialogBuilder.setPositiveButton("Aceptar"){_, _->
                Toast.makeText(this@MercadoInteligente, "EMA seleccionado", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNegativeButton("Borrar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "EMA borrada", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNeutralButton("Cancelar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "EMA cancelada", Toast.LENGTH_LONG).show()
            }
            val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()

    }//Finaliza funcion EMA

    //Funcion para el boton RSI
    fun rsi(view : View){

        val  programming_lang = arrayOf("Sobre compra","Sobre venta",">50 bajando",">50 Creciendo",
                                        "<50 bajando", "<50 Creciendo")
        var checkedItem = -1

            val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

            mAlertDialogBuilder.setTitle("RSI")
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
                Toast.makeText(this@MercadoInteligente, "RSI seleccionado", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNegativeButton("Borrar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "RSI borrada", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNeutralButton("Cancelar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "RSI cancelada", Toast.LENGTH_LONG).show()
            }
            val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()

    }//Finaliza funcion RSI

    //Funcion para el boton Koncorde
    fun koncorde(view : View){

        val  programming_lang = arrayOf("Ballenas compran","Peces compran","Ballenas Venden","Peces Venden")
        var checked_items = booleanArrayOf(false,false,false,false)

            val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

            mAlertDialogBuilder.setTitle("koncorde")
            mAlertDialogBuilder.setIcon(R.mipmap.ic_launcher)
            mAlertDialogBuilder.setCancelable(false)

            mAlertDialogBuilder.setMultiChoiceItems(programming_lang,checked_items) { dialog, which, isChecked ->
                when(which){
                    which -> {
                        Toast.makeText(this@MercadoInteligente, programming_lang[which], Toast.LENGTH_LONG).show()
                    }
                }
            }
            mAlertDialogBuilder.setPositiveButton("Aceptar"){_, _->
                Toast.makeText(this@MercadoInteligente, "koncorde seleccionado", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNegativeButton("Borrar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "koncorde borrada", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNeutralButton("Cancelar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "koncorde cancelada", Toast.LENGTH_LONG).show()
            }
            val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()

    }//Finaliza funcion Koncorde

    //Funcion para el boton MACD
    fun macd(view : View){

        val  programming_lang = arrayOf("Compra creciente","Compra decreciente","Venta creciente","Venta decreciente",
                                         "Compra","Venta")
        var checkedItem = -1

            val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

            mAlertDialogBuilder.setTitle("MACD")
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
                Toast.makeText(this@MercadoInteligente, "MACD seleccionado", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNegativeButton("Borrar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "MACD borrada", Toast.LENGTH_LONG).show()
            }
            mAlertDialogBuilder.setNeutralButton("Cancelar"){_, _ ->
                Toast.makeText(this@MercadoInteligente, "MACD cancelada", Toast.LENGTH_LONG).show()
            }
            val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()

    }//Finaliza funcion MACD

    //Funcion para el boton PSAR
    fun psar(view : View){

        val  programming_lang = arrayOf("Compra","Venta")
        var checkedItem = -1

        val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

        mAlertDialogBuilder.setTitle("Parabolic sar")
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
            Toast.makeText(this@MercadoInteligente, "PSAR seleccionado", Toast.LENGTH_LONG).show()
        }
        mAlertDialogBuilder.setNegativeButton("Borrar"){_, _ ->
            Toast.makeText(this@MercadoInteligente, "PSAR borrada", Toast.LENGTH_LONG).show()
        }
        mAlertDialogBuilder.setNeutralButton("Cancelar"){_, _ ->
            Toast.makeText(this@MercadoInteligente, "PSAR cancelada", Toast.LENGTH_LONG).show()
        }
        val mAlertDialog = mAlertDialogBuilder.create()
        mAlertDialog.show()

    }//Finaliza funcion PSAR



}
