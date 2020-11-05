package com.example.tp_istic_2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_item.*
import kotlinx.android.synthetic.main.item.*

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        val item= intent.getSerializableExtra("item") as Item
        nombre_item.text=item.nombre
        detalles_item.text=item.descripcion
        imageView.setImageResource(item.imagen)

    }
}