package com.example.ferretexapp.Client.Historial.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ferretexapp.R

import java.io.Serializable

//Objeto donde tenemos todos los datos que le vamos a pasar a la lista
class Historial(val nombre: String, val precio: Double, val descripcion: String, val imagen:Int):Serializable