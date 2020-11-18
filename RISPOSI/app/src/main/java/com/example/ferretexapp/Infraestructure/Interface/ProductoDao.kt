package com.example.ferretexapp.Infraestructure.Interface

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ferretexapp.Infraestructure.Model.Producto


//Para acceder a los datos dao(Data access objet)
@Dao
interface ProductoDao {
    @Query("SELECT * FROM productos")
    fun getAll() : LiveData<List<Producto>>

    @Query("SELECT * FROM productos WHERE idProducto = :id")
    fun get(id: Int): LiveData<Producto>

    @Insert
    fun insertAll(vararg producto: Producto):List<Long>

    @Update
    fun update(producto: Producto)

    @Delete
    fun delete(producto: Producto)
}


