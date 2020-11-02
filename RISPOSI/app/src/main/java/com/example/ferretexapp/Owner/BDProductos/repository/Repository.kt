package com.example.ferretexapp.Owner.BDProductos.repository

import com.example.ferretexapp.Owner.BDProductos.api.RetrofitInstance
import com.example.ferretexapp.Owner.BDProductos.model.Post

class Repository {
    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}