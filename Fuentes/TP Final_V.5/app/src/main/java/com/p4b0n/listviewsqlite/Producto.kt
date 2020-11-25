package com.p4b0n.listviewsqlite

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "productos")
class Producto(
    val nombre:String,
    val precio: Double,
    val descripcion: String,
    val codigo: String,
    val imagen: Int,
    @PrimaryKey(autoGenerate = true)
    var idProducto: Int = 0
) : Serializable