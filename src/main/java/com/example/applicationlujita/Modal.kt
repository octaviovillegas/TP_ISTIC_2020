package com.example.applicationlujita

import java.io.Serializable

class Modal : Serializable{

    var name:String? =null
    var image:Int? = null

    constructor(name: String, image: Int) {
        this.name = name;
        this.image = image;
    }
}