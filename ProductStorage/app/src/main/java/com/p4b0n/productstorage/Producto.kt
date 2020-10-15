package com.p4b0n.productstorage

import java.io.Serializable

class Producto(
    var nombre: String,
    var lanzamiento: String,
    var lenguaje: String,
    var publico: Int,
    var puntaje: Double,
    var imagenpeli: String

) : Serializable