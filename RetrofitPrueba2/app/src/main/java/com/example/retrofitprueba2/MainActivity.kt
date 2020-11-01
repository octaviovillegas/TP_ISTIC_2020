package com.example.retrofitprueba2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitprueba2.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Files.find

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response",response.userId.toString())
            Log.d("Response", response.id.toString())
            Log.d("Response",response.title)
            Log.d("Response",response.body)
        })

        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val edtCodigo=findViewById<EditText>(R.id.edtCodigo)
        val tvNombre=findViewById<TextView>(R.id.tvNombre)
        val tvDescripcion=findViewById<TextView>(R.id.tvDescripcion)
        val tvPrecio=findViewById<TextView>(R.id.tvPrecio)

        btnBuscar.setOnClickListener(){
            viewModel.myResponse.observe(this, Observer { response ->
                tvNombre.text = response.id.toString()
                tvDescripcion.text = response.title
                tvPrecio.text = response.body
            })
        }

    }
}
