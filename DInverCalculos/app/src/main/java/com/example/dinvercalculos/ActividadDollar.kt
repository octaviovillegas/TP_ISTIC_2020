package com.example.dinvercalculos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.util.Log
import kotlinx.android.synthetic.main.activity_actividaddollar.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Array.getDouble

class ActividadDollar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividaddollar)


        val datos =  claseFunciones.consultarDatos("https://www.dolarsi.com/api/api.php?type=valoresprincipales")

        val arrayDenombreDeDollar: ArrayList<String> = ArrayList()
        val arrayDeobjetosDeDollar: ArrayList<ClaseDollar> = ArrayList()
        //val datosJSONObject = JSONObject(datos)
        val datosArrayJson = JSONArray(datos);

        for (i in 0..7) {
            var dollar = datosArrayJson.getJSONObject(i)
            Log.d("Cotizacion dollar", dollar.getString("casa"))
            arrayDenombreDeDollar.add(dollar.getString("casa"))
            if((i == 0) || (i ==1) || (i ==3) || (i ==4)){
            arrayDeobjetosDeDollar.add(
                ClaseDollar(
                    dollar.getJSONObject("casa").getString("nombre"),
                    dollar.getJSONObject("casa").getString("venta"),
                    dollar.getJSONObject("casa").getString("compra"),
                    dollar.getJSONObject("casa").getString("variacion")

                )
            )
            }

        }
        val adaptadorSimple = AdaptadorLsvDollar(this, arrayDeobjetosDeDollar)
        ListaDollar.adapter = adaptadorSimple

    }
}
