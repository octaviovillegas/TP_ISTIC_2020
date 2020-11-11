package com.example.tp_istic_2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alta_inf.*
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class modificarInf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_inf)
        btnGuardado.setOnClickListener {

            lblItem.setText("")
            lblNumeroItem.setText("")
        }
    }
    private fun modificacion(){
        SQLiteOpenHelper admin=new SQLiteOpenHelper(this,)
    }
}