package com.example.proyecto_nosayudamosentretodos_nuez

import java.io.Serializable

class Articulo (id:Int,titulo:String,categoria:String,tipo:String,descripcion:String,localidad:String,codiPos:String,telefono:String/*,imagen:Int*/) : Serializable  {



    var id:Int
    var titulo:String
    var categoria:String
    var tipo:String
    var descripcion:String
    var localidad:String
    var codiPos:String
    var telefono:String
    //var imagen: Int




    init{
        this.id=id
        this.titulo=titulo
        this.categoria=categoria
        this.tipo= tipo
        this.descripcion=descripcion
        this.localidad=localidad
        this.codiPos=codiPos
        this.telefono=telefono
        //this.imagen=imagen

    }
}















/*(titulo:String, categoria:String,tipo:String, descripcion:String,localidad:String,codiPos:String,telefono:String) :
    Serializable {

    var titulo:""
    var categoria:""
    var tipo:""
    var descripcion:""
    var localidad:""
    var codiPos:""
    var telefono:""
    //var imagen:""

    init{
        this.titulo=titulo
        this.categoria=categoria
        this.tipo=tipo
        this.descripcion=descripcion
        this.localidad=localidad
        this.codiPos=codiPos
        this.telefono=telefono

    }
}*/

/*/
        class Articulo (


    val titulo:String,
    val categoria:String,
    val tipo:String,
    val descripcion:String,
    val localidad:String,
    val codiPos:String,
    val telefono:String,
    val imagen: Int


)

 */