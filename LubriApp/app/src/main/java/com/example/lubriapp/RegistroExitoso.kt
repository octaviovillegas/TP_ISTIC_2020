package com.example.lubriapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registro_exitoso.*

class RegistroExitoso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_exitoso)

        btnOk.setOnClickListener {
            val intent: Intent = Intent(this, Login ::class.java)
            startActivity(intent)
            finish()
        }
    }
}