package com.example.androidretrofitapi.Interfaces

import android.telecom.Call
import com.example.androidretrofitapi.models.Producto
import retrofit2.http.GET
import retrofit2.http.Path



internal interface ProductoAPI {
    @GET("api/Productos/{id}")
    fun find(@Path("id") id: String): Call
}

