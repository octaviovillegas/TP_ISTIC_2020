package com.example.dinvercalculos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_actividad_bitcoin.*
import kotlinx.android.synthetic.main.activity_actividaddollar.*
import org.json.JSONArray
import org.json.JSONObject

class ActividadBitcoin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_bitcoin)

        val datos =  claseFunciones.consultarDatos("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?start=1&limit=100&CMC_PRO_API_KEY=7e7a64cc-2f20-42c6-9d99-68cd8546b5a6")

        val arrayDenombreDeBTC: ArrayList<String> = ArrayList()
        val arrayDeobjetosDeBTC: ArrayList<ClaseBTC> = ArrayList()
        val datosJSONObject = JSONObject(datos)
        //val datosArrayJson = JSONArray(datos);

        for (i in 0..7) {
            //var btc = datosArrayJson.getJSONObject(i)
            //Log.d("Cotizacion BTC", btc.getString("casa"))
            //arrayDenombreDeBTC.add(btc.getString("casa"))
            if((i == 0) || (i ==1) || (i ==2) || (i ==3) || (i ==6) || (i ==7) || (i ==9) ||
                (i ==11) || (i ==12) || (i ==15) || (i ==22) || (i ==23) || (i ==26) || (i ==29)
                || (i ==34) || (i ==76) ) {
                arrayDeobjetosDeBTC.add(
                    ClaseBTC(
                        datosJSONObject.getJSONArray("data").getJSONObject(i).getString("name"),
                        datosJSONObject.getJSONArray("data").getJSONObject(i).getString("symbol"),
                        datosJSONObject.getJSONArray("data").getJSONObject(i).getJSONObject("quote")
                            .getJSONObject("USD").getDouble("price")

                    )
                )
            }

        }
        val adaptadorSimple = AdaptadorLsvBitcoin(this, arrayDeobjetosDeBTC)
        ListaBTC.adapter = adaptadorSimple
    }
}
