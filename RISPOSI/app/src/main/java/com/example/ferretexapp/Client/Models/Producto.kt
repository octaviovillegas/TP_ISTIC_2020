package com.example.ferretexapp.Client.Models

import java.io.Serializable

//Objeto donde tenemos todos los datos que le vamos a pasar a la lista
class Producto(val nombre: String, val precio: Double, val descripcion: String, val imagen:Int):
    Serializable