package com.example.food_locator

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
val logAct = LoginActivity()
    val MaiAct = MainActivity()
    object staa{
        var LOGIN_PRFS = "login feature"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var ncontext : Context?=null
        Handler().postDelayed({
            val starAc = Intent(this@SplashActivity,LoginActivity::class.java)
            startActivity(starAc)
            this.finish()
        },2000)
    }
}
