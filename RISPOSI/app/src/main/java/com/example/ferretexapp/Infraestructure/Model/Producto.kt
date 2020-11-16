package com.example.ferretexapp.Infraestructure.Model
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "productos")
data class Producto(
    val nombre:String,
    val precio: Double,
    val descripcion: String,
    val imagen: Int,
    @PrimaryKey(autoGenerate = true)
    var idProducto: Int = 0
): Serializable