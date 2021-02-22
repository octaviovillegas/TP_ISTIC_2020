package com.example.parcial_julissa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.parcial_julissa.datamodels.Persona
import com.example.parcial_julissa.datamodels.User
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeActivity : AppCompatActivity() {
    private var usuario: User? =null
    private var user: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        buscarUsuario()
        val btnEnviarDinero = findViewById<Button>(R.id.btnEnviarDinero)
        val saldo = findViewById<TextView>(R.id.input_saldo)


        btnEnviarDinero.setOnClickListener {
            val intentDos = Intent(this, AmigosActivity::class.java)
            startActivity(intentDos)
        }
        var saldovalue="0"
        if (usuario!=null) saldovalue=usuario!!.saldo.toString()
        saldo.setText(saldovalue)


    }
    private fun DbReference(): FirebaseDatabase {
        val dbRef= FirebaseDatabase.getInstance()
        return dbRef
    }
    private fun buscarUsuario() {
        try {

            val dbref = DbReference()
            val usuariosReference= dbref.getReference("Usuarios").child(user!!.uid)

            usuariosReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    usuario = dataSnapshot.getValue(User::class.java)!!
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }catch (ex: Throwable){}
    }
}