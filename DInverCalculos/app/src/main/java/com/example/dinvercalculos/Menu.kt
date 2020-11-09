package com.example.dinvercalculos

import android.content.Intent
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

        custom_list_data.add(CList(R.drawable.calculos,"Calculos","Calculos de inversion"))
        custom_list_data.add(CList(R.drawable.dollars,"Dollar","Valor del dollar"))
        custom_list_data.add(CList(R.drawable.btc,"Bitcoin","Valor del BTC y critos"))
        custom_list_data.add(CList(R.drawable.claves,"Mis Claves","Sus claves"))
        custom_list_data.add(CList(R.drawable.link,"Links de trading","Sus webs favoritas"))

        listView.adapter = custom_list

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this@Menu, "Cargando... ", Toast.LENGTH_SHORT).show()

            if (position == 0)
            {
                val intent = Intent(this, MenuDeCalculos::class.java)
                startActivity(intent)
            }else if (position == 1)
            {
                val intent = Intent(this, ActividadDollar::class.java)
                startActivity(intent)
            } else if (position == 2)
            {
                val intent = Intent(this, ActividadBitcoin::class.java)
                startActivity(intent)
            }else if (position == 3)
            {
                val intent = Intent(this, MisClaves::class.java)
                startActivity(intent)
            }else if (position == 4)
            {
                val intent = Intent(this, LinksTrader::class.java)
                startActivity(intent)
            }

        }
    }
}
