package com.example.tp_istic_2020

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alta_inf.*

class altaInf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alta_inf)
        btnGuardado.setOnClickListener {
            ingresarItem()
            lblItem.setText("")
            lblNumeroItem.setText("")
        }
        btnAtras.setOnClickListener {
            val intent: Intent = Intent(this, menuCRUD ::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun ingresarItem(){
        if(this.lblItem.getText().isNotEmpty()&&this.lblNumeroItem.getText().isNotEmpty() )
        {

            var informe=this.lblItem.getText().toString()
            var nombre=this.lblNumeroItem.getText().toString()

            try {
                val admin = bdd(this,"SqLite2020", null, 2)
                val bd = admin.writableDatabase
                val registro = ContentValues()
                registro.put("informe",informe)
                registro.put("nombre",nombre)
                bd.insert("informacion", null, registro)
                bd.close()
                Toast.makeText(this, "Item subido correctamente", Toast.LENGTH_SHORT).show()
            }catch (e:Throwable)
            {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }

        }else
        {
            Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show()
        }

    }
}