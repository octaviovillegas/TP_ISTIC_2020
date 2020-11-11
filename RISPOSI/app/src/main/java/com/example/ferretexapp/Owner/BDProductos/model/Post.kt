package com.example.ferretexapp.Owner.BDProductos.model

import com.google.gson.annotations.SerializedName

class Post (
    @SerializedName("userId")
    //El correcto
    //val pro_codigo:String,
    //val pro_nombre:String,
    //val pro_descripcion:String,
    //val pro_precio:Double

    //Prueba

    val userId:Int,
    val id:Int,
    val title:String,
    val body:String


)
