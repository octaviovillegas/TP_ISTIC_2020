package com.example.dinvercalculos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Calculos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculos)

        val btnSrpead = findViewById<Button>(R.id.btnSrpead)
        btnSrpead.setOnClickListener {
            val Spread = Intent(this, Spread::class.java)
            startActivity(Spread)
        }
    }
}
