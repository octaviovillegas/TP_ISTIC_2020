package com.example.food_locator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast
import com.example.food_locator.AppDatabase.transdb.C_NAME
import com.example.food_locator.AppDatabase.transdb.C_PASSWORD
import com.example.food_locator.AppDatabase.transdb.TABLE_LOGIN


class LoginActivity : AppCompatActivity() {

    var signbtn:Button?= null
    var loginbtn:Button?= null
    var name:EditText?= null
    var pass:EditText?= null
  //  var activity= LoginActivity()
    var db:AppDatabase= AppDatabase(this,"nombre",null,1)
    var ab: Datahelper = Datahelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
 //   activity.title = "Litter Locator"
        signbtn = findViewById(R.id.Signbtn)
    loginbtn = findViewById(R.id.loginbtn)
    name = findViewById(R.id.lEmail)
    pass = findViewById(R.id.lPassword)
        loginbtn?.setOnClickListener {
            var na = name?.text.toString()
            var pa = pass?.text.toString()
            db.queryLogin(na,pa)

        if (Datahelper.car.testtry ){
            var intent: Intent?=null
            intent = Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
        }else{
           name?.setText("")
            pass?.setText("")
            Toast.makeText(this@LoginActivity,"Datos Incorrectos",Toast.LENGTH_LONG).show()
        }
         //   Toast.makeText(this@LoginActivity, Datahelper.car.testtry,Toast.LENGTH_LONG).show()

        }
        signbtn?.setOnClickListener {
            var intent: Intent?= null
            intent = Intent(this@LoginActivity,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}
