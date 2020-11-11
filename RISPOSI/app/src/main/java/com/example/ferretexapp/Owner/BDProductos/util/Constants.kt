package com.example.ferretexapp.Owner.BDProductos.util

class Constants {
    //Copiar el path del url sin el end point
    //Este companion object lo vamos a utilizar para hacer una conexión singleton
    //PAra el caso de haberlo subido al host sería http://192.168.0.205:8081/
    //Mientras probamos con la ruta de localhost
    companion object{
        //const val BASE_URL = "https://localhost/192.168.0.205:44348"
        //Mockeado
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        //const val BASE_URL = "https://localhost:44348"
    }
}