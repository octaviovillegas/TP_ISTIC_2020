package com.example.ferretexapp.Owner.BDProductos.api

import com.example.ferretexapp.Owner.BDProductos.model.Post
import retrofit2.http.GET

interface SimpleApi {
    //Metodo para buscar el producto
    //Colocar bien el End Point

    //El correcto
    //@GET("/api/Productos/{id}")

    //Prueba
    @GET("/posts/1")

    suspend fun getPost(): Post
}