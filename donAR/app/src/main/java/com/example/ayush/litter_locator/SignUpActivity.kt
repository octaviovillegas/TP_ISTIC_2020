package com.example.food_locator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SignUpActivity : AppCompatActivity() {
    var btn :Button?= null
    var tf1:EditText?=null
    var tf2:EditText?=null
    var tf3:EditText?=null
    var tf4:EditText?=null
    var tf5:EditText?=null
    var db:AppDatabase = AppDatabase(this,"nombre",null,1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        tf1 = findViewById(R.id.nameTf)
        tf2 = findViewById(R.id.emailTf)
        tf3 = findViewById(R.id.pWordTf)
        tf4 = findViewById(R.id.cpWordTf)
        tf5 = findViewById(R.id.mnoTf)


        btn = findViewById(R.id.signupBtn)
        btn?.setOnClickListener {
            val n1 = tf1?.text.toString()
            val n2 = tf2?.text.toString()
            val n3 = tf3?.text.toString()
            val n4 = tf4?.text.toString()
            val n5 = tf5?.text.toString()
            if(n3.equals(n4)){
                db.storeDetails(n1,n2,n3,n5)
                Toast.makeText(this@SignUpActivity,"Cuenta Creada, "+n1,Toast.LENGTH_LONG).show()
                var intent:Intent? = null
                intent = Intent(this@SignUpActivity,LoginActivity::class.java)
                startActivity(intent)
            }else{
                tf3?.setText("")
                tf3?.hint = "Error Contraseña"
                tf4?.setText("")
            }
        }
    }
}
