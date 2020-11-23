package com.example.dinvercalculos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.app.AlertDialog
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mercado_inteligente.*
import java.io.IOException
import java.lang.reflect.MalformedParametersException

class MercadoInteligente : AppCompatActivity() {

    var cVolPos:Double = 0.00
    var cVolNeg:Double = 0.00
    var cEmaPos:Double = 0.00
    var cEmaNeg:Double = 0.00
    var cRsiPos:Double = 0.00
    var cRsiNeg:Double = 0.00
    var cKonPos:Double = 0.00
    var cKonNeg:Double = 0.00
    var cMacPos:Double = 0.00
    var cMacNeg:Double = 0.00
    var cPsarPos:Double = 0.00
    var cPsarNeg:Double = 0.00


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercado_inteligente)


        val btnEjecutar = findViewById<Button>(R.id.btnEjecutar)


        btnEjecutar.setOnClickListener {
            calculoInteligente()
        }

    }

    //Funcion para el boton volumen
    fun volumen(view : View){
        cVolPos = 0.00
        cVolNeg = 0.00
        try {

        val  programming_lang = arrayOf("Creciendo - bajo","Descendente - bajo","Creciendo - Alto","Descendente - alto")
        var checkedItem = -1

            val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

            mAlertDialogBuilder.setTitle("Volumen")
            mAlertDialogBuilder.setIcon(R.mipmap.ic_launcher)
            mAlertDialogBuilder.setCancelable(false)

            mAlertDialogBuilder.setSingleChoiceItems(programming_lang, checkedItem) {dialog, which ->
                when (which){
                    which -> {
                        if (which == 0)
                        {
                            cVolPos = 0.50
                        }else if (which == 1)
                        {
                            cVolNeg = 0.50
                        }else if (which == 2)
                        {
                            cVolPos = 1.00
                        }else if (which == 3)
                        {
                            cVolNeg = 1.00
                        }
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

        }catch (e: IOException) {
            claseFunciones.ttoas("Error en boton volumen",this)
        }

    }//Finaliza funcion volumen

    //Funcion para el boton EMA
    fun ema(view : View){
        cEmaPos = 0.00
        cEmaNeg = 0.00
        try {

        val  programming_lang = arrayOf("Debajo EMA 21","Sobre EMA 21","Cruce dorado!!!","Cruce peligroso")
        var checkedItem = -1

            val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

            mAlertDialogBuilder.setTitle("EMA Exponencial")
            mAlertDialogBuilder.setIcon(R.mipmap.ic_launcher)
            mAlertDialogBuilder.setCancelable(false)

        mAlertDialogBuilder.setSingleChoiceItems(programming_lang, checkedItem) {dialog, which ->
            when (which){
                which -> {
                    if (which == 0)
                    {
                        cEmaNeg = 1.50
                    }else if (which == 1)
                    {
                        cEmaPos = 1.5
                    }else if (which == 2)
                    {
                        cEmaPos = 3.00
                    }else if (which == 3)
                    {
                        cEmaNeg = 3.00
                    }
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

        }catch (e: IOException) {
            claseFunciones.ttoas("Error en boton EMA",this)
        }
    }//Finaliza funcion EMA

    //Funcion para el boton RSI
    fun rsi(view : View){
        cRsiPos = 0.00
        cRsiNeg = 0.00
        try {

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
                    if (which == 0)
                    {
                        cRsiNeg = 1.00
                    }else if (which == 1)
                    {
                        cRsiPos = 1.00
                    }else if (which == 2)
                    {
                        cRsiNeg = 0.50
                    }else if (which == 3)
                    {
                        cRsiPos = 1.50
                    }else if (which == 4)
                    {
                        cRsiNeg = 1.50
                    }else if (which == 5)
                    {
                        cRsiPos = 0.50
                    }
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

        }catch (e: IOException) {
            claseFunciones.ttoas("Error en boton RSI",this)
        }
    }//Finaliza funcion RSI

    //Funcion para el boton Koncorde
    fun koncorde(view : View){
        cKonPos = 0.00
        cKonNeg = 0.00
        try {

        val  programming_lang = arrayOf("Ballenas y peces compran","Ballenas y peces Venden",
                                        "Ballenas compran, peces venden","Ballenas venden, peces compran")
        var checked_items = booleanArrayOf(false,false,false,false)

            val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

            mAlertDialogBuilder.setTitle("koncorde")
            mAlertDialogBuilder.setIcon(R.mipmap.ic_launcher)
            mAlertDialogBuilder.setCancelable(false)

            mAlertDialogBuilder.setMultiChoiceItems(programming_lang,checked_items) { dialog, which, isChecked ->
                when(which){
                    which -> {
                        if (which == 0)
                        {
                            cKonPos = 1.50
                        }else if (which == 1)
                        {
                            cKonNeg = 1.50
                        }else if (which == 2)
                        {
                            cKonPos = 1.00
                        }else if (which == 3) {
                            cKonNeg = 1.00
                        }

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

        }catch (e: IOException) {
            claseFunciones.ttoas("Error en boton Koncorde",this)
        }
    }//Finaliza funcion Koncorde

    //Funcion para el boton MACD
    fun macd(view : View){
        cMacPos = 0.00
        cMacNeg = 0.00
        try {

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
                    if (which == 0)
                    {
                        cMacPos = 1.00
                    }else if (which == 1)
                    {
                        cMacNeg = 0.50
                    }else if (which == 2)
                    {
                        cMacNeg = 1.00
                    }else if (which == 3) {
                        cMacPos = 1.00
                    }else if (which == 4) {
                        cMacPos = 1.50
                    }else if (which == 5) {
                        cMacNeg = 1.50
                    }

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

        }catch (e: IOException) {
            claseFunciones.ttoas("Error en boton MACD",this)
        }
    }//Finaliza funcion MACD

    //Funcion para el boton PSAR
    fun psar(view : View){
        cPsarPos = 0.00
        cPsarNeg = 0.00
        try {

        val  programming_lang = arrayOf("Compra","Venta")
        var checkedItem = -1

        val mAlertDialogBuilder = AlertDialog.Builder(this@MercadoInteligente)

        mAlertDialogBuilder.setTitle("Parabolic sar")
        mAlertDialogBuilder.setIcon(R.mipmap.ic_launcher)
        mAlertDialogBuilder.setCancelable(false)

        mAlertDialogBuilder.setSingleChoiceItems(programming_lang, checkedItem) {dialog, which ->
            when (which){
                which -> {
                    if (which == 0)
                    {
                        cPsarPos = 1.50
                    }else if (which == 1)
                    {
                        cPsarNeg = 1.50
                    }

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

        }catch (e: IOException) {
            claseFunciones.ttoas("Error en boton Psar",this)
        }
    }//Finaliza funcion PSAR

    fun calculoInteligente()
    {
        var riesgoPos:Double = 0.00
        var riesgoNeg:Double = 0.00

        riesgoPos = (cVolPos + cEmaPos + cRsiPos + cKonPos + cMacPos + cPsarPos)
        riesgoNeg = (cVolNeg + cEmaNeg + cRsiNeg + cKonNeg + cMacNeg + cPsarNeg)

        txtResultInteligente.text = "Riesgo beneficio: " + riesgoPos.toString() + "/" + riesgoNeg.toString()

    }


}
