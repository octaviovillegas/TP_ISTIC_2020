package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListViewProductos : AppCompatActivity() {

    private lateinit var lstProductView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        lstProductView = findViewById(R.id.list_view_lstProductos)
    }
}