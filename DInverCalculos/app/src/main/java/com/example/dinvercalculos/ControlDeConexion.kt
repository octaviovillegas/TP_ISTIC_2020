package com.example.dinvercalculos

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class ControlDeConexion {
    companion object{
        //https://www.it-swarm.dev/es/android/activenetworkinfo.type-esta-en-desuso-en-el-nivel-28-de-api/808227830/
        fun hayConexion(context: Context):Boolean{
            (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).apply {
                return getNetworkCapabilities(activeNetwork)?.run {
                    when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                } ?: false
            }
        }
    }
}