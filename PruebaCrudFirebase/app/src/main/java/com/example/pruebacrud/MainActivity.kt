package com.example.pruebacrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTxt = findViewById<EditText>(R.id.editTxtName)
        val rtgBar = findViewById<RatingBar>(R.id.rtgBar)
        val btnSave=findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener(){
            saveHero()
        }

    }

    private fun saveHero(){
        val name = editTxtName.text.toString().trim()

        if(name.isEmpty()){
            editTxtName.error = "Please entera a name"
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("heroes")

    }

}
