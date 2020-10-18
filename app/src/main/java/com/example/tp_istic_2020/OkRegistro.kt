package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ok_registro.*

class OkRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_registro)
        btnOk.setOnClickListener {
            val intent: Intent = Intent(this, ActividadLogin ::class.java)
            startActivity(intent)
            finish()
        }
    }
}