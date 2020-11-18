package com.example.dinvercalculos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.app.AlertDialog
import android.widget.Toast
import java.lang.reflect.MalformedParametersException

class MercadoInteligente : AppCompatActivity() {

    lateinit var mAlertButton: Button

    val  programming_lang = arrayOf("Creciendo - bajo","Descendente - bajo","Creciendo - Alto","Descendente - alto")

    var checkedItem = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mercado_inteligente)

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

    }

}
