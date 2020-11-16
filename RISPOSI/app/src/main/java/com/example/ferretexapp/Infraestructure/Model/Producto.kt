package com.example.ferretexapp.Infraestructure.Model
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "productos")
data class Producto(
    val nombre:String,
    val precio: Double,
    val descripcion: String,
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
): Serializable