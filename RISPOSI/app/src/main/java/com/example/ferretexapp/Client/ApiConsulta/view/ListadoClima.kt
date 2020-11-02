package com.example.ferretexapp.Client.ApiConsulta.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ListView
import android.widget.Toast
import com.example.ferretexapp.Client.ApiConsulta.controller.adaptadorClima
import com.example.ferretexapp.Client.ApiConsulta.model.Clima
import com.example.ferretexapp.R
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class ListadoClima : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_clima)

        //Definición de Variables
        var lsvClima = findViewById<ListView>(R.id.LsvClima)
        val datos =
            consultarDatos("https://api.mocki.io/v1/d520afdc")
        val arrayDeobjetosDeClima: ArrayList<Clima> = ArrayList()
        val arrayDeNombreDeClima: ArrayList<String> = ArrayList()
        val datosObjectJson = JSONObject(datos);
        //val datosArrayJson = JSONArray(datos);

        //Recorro el Json
        for (i in 0..5) {
            arrayDeobjetosDeClima.add(
                Clima(
                    datosObjectJson.getJSONArray("list").getJSONObject(i).getString("name"),
                    datosObjectJson.getJSONArray("list").getJSONObject(i).getJSONObject("coord").getDouble("lat"),
                    datosObjectJson.getJSONArray("list").getJSONObject(i).getJSONObject("coord").getDouble("lon"),
                    datosObjectJson.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("temp")
                )
            )
        }

        val adaptadorClima = adaptadorClima(this, arrayDeobjetosDeClima)
        lsvClima.adapter = adaptadorClima

        lsvClima.setOnItemClickListener { parent, view, position, id ->
            var ClimaDetailIntent = Intent(this, DetalleClima::class.java)
            ClimaDetailIntent.putExtra("DetalleClima", arrayDeobjetosDeClima[position])
            startActivity(ClimaDetailIntent)
        }
    }

    //Defino el Método GET
    @Throws(IOException::class)
    private fun consultarDatos(url:String):String{
        val policy= StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var datosDescargados: InputStream?=null
        try{
            val direccionWEB= URL(url)
            val conexion=direccionWEB.openConnection() as HttpURLConnection
            conexion.requestMethod="GET"
            conexion.connect()
            datosDescargados=conexion.inputStream
            return datosDescargados.bufferedReader().use{
                it.readText()
            }
        }catch (e: IOException)
        {
            Toast.makeText(this,"${e.message}", Toast.LENGTH_SHORT).show()
        }
        finally {
            if(datosDescargados!=null)
            {
                datosDescargados.close()
            }
        }
        return "NADA"

    }
}
