package com.example.retrofitprueba2.repository

import com.example.retrofitprueba2.api.RetrofitInstance
import com.example.retrofitprueba2.model.Post
import retrofit2.Retrofit

class Repository {
    suspend fun getPost():Post{
        return RetrofitInstance.api.getPost()
    }
}