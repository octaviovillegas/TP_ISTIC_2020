package com.example.dinvercalculos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val listView = findViewById<ListView>(R.id.listView)

        val custom_list_data =  ArrayList<CList>()

        val custom_list = CListAdapter(this,custom_list_data)

        custom_list_data.add(CList(R.drawable.arroba,"Calculos","This is custom date"))
        custom_list_data.add(CList(R.drawable.arroba,"VDolar","This is custom date"))
        custom_list_data.add(CList(R.drawable.arroba,"VBitcoin","This is custom date"))
        custom_list_data.add(CList(R.drawable.arroba,"MisClaves","This is custom date"))
        custom_list_data.add(CList(R.drawable.arroba,"LTrading","This is custom date"))

        listView.adapter = custom_list

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this@Menu, "Item Clicked:- $id", Toast.LENGTH_SHORT).show()
        }
    }
}
