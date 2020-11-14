package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView
import com.example.listadecompras.Adapters.AdapterProductList
import com.example.listadecompras.Adapters.AdapterSearchProductList
import com.example.listadecompras.DataModels.Product

class BuscarProductoLista : AppCompatActivity() {

    private lateinit var lstProductView: ListView
    private lateinit var buscar_producto_txt_search: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_producto_lista)

        var arrayProd = inicializar()

        buscar_producto_txt_search = findViewById(R.id.buscar_producto_txt_search)
        lstProductView = findViewById(R.id.buscar_producto_lst_prod)

        val adaptadorSimple = AdapterSearchProductList(this, arrayProd)
        lstProductView.adapter = adaptadorSimple
//        buscar_producto_txt_search.addTextChangedListener(object : TextWatcher {
//
//            override fun afterTextChanged(s: Editable) {
//
//            }
//
//            override fun beforeTextChanged(s: CharSequence, start: Int,
//                                           count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int,
//                                       before: Int, count: Int) {
//            }
//        })

    }

    fun inicializar() :ArrayList<Product>
    {
        var arrayProducts: ArrayList<Product> = ArrayList()

        for (i in 1..10){
            arrayProducts.add(
                Product(
                    "Coca",
                    "150",
                    "",
                    "Coca Cola",
                    "2.25Lts",
                    "Coto",
                    3))
        }
        return arrayProducts
    }
}