package com.example.food_locator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SucessActivity : AppCompatActivity() {
var Home_btn: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sucess)
        Home_btn = findViewById(R.id.homeBtn)

        Home_btn?.setOnClickListener {
            var intent:Intent?=null
            intent = Intent(this@SucessActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
