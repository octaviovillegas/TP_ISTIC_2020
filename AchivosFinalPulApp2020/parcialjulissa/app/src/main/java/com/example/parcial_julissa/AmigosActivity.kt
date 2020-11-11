package com.example.parcial_julissa

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial_julissa.datamodels.AmigoAdapter
import com.example.parcial_julissa.datamodels.Persona
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class AmigosActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    private var personas:ArrayList<Persona> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amigos)
//        buscarUsuario()

       val misAmigos= arrayOf(
            "Belony Valeria", "Farah Sharma", "Steve Bryan",
            "Kane Pedro", "Ross Taylor"
        )

//        val adapter = AmigoAdapter(this, personas)
//        listView = findViewById(R.id.amigo_list_view)
//
//        listView.adapter = adapter

        val listViewAdapter: ArrayAdapter<*>

        var mListView = findViewById<ListView>(R.id.amigo_list_view)
        listViewAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, misAmigos)
        mListView.adapter = listViewAdapter
        mListView.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            val intentDos = Intent(this, EnvioActivity::class.java)
            startActivity(intentDos)
        })
    }


    private fun DbReference(): FirebaseDatabase {
        val dbRef= FirebaseDatabase.getInstance()
        return dbRef
    }
    private fun buscarUsuario() {
        try {

            val dbref = DbReference()
            val usuariosReference= dbref.getReference("Usuarios")

            usuariosReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    val value = dataSnapshot.getValue(Persona::class.java)!!
                    personas.add(value)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }catch (ex: Throwable){}
    }
}