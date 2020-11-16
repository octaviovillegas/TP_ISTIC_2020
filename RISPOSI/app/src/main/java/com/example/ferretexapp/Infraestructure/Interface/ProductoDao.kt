package com.example.ferretexapp.Infraestructure.Interface

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.ferretexapp.Client.Models.Producto
import retrofit2.http.Query

//Para acceder a los datos dao(Data access objet)
@Dao
interface ProductoDao {
    @Query("SELECT * FROM productos")
    fun getAll() : LiveData<List<Producto>>

    @Insert
    fun insertAll(vararg producto: Producto)

    @Update
    fun update(producto: Producto)

    @Delete
    fun delete(producto: Producto)
}


