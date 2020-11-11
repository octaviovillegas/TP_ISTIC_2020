package com.example.tp_istic_2020

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alta_inf.*
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class modificarInf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_inf)
        btnAtras.setOnClickListener {
            val intent: Intent = Intent(this, menuCRUD ::class.java)
            startActivity(intent)
            finish()
        }
        btnGuardado.setOnClickListener {
val admin= bdd(this,"SqLite2020",null,2)
            val bd=admin.writableDatabase
            val registro= ContentValues()
            registro.put("informe",lblItem.text.toString())
         //   registro.put("numero",lblNumeroItem.text.toString())
            val cant= bd.update("informacion",registro,"nombre=${lblNumeroItem.text.toString()}",null)
            bd.close()
           if(cant==1){
               Toast.makeText(this,"se modifico con éxito", Toast.LENGTH_SHORT).show()}
               else
           { Toast.makeText(this,"no existe item con el nimero ingresado", android.widget.Toast.LENGTH_SHORT).show()


           }
        }
    }

}