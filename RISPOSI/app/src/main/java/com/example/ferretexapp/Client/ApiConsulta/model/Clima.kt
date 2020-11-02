package com.example.ferretexapp.Client.ApiConsulta.model

import java.io.Serializable

class Clima(name:String,lat:Double,long:Double,temp:Double):Serializable{
    var name=""
    var lat=""
    var long=""
    var temp=""
    init{
        this.name=name
        this.lat= lat.toString()
        this.long=long.toString()
        this.temp=temp.toString()
    }
}