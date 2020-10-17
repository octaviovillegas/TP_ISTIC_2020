package com.example.dinvercalculos

import android.content.Context
import android.view.Gravity
import android.widget.Toast

class claseFunciones {

    companion object{

        fun ttoas(mensaje:String,contexto: Context){//Funcion para mensaje toast

            var toast = Toast.makeText(contexto,"$mensaje", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }

    }
}