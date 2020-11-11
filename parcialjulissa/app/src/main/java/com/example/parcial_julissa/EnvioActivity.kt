package com.example.parcial_julissa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parcial_julissa.datamodels.User
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import android.widget.Button
import android.widget.Toast
import com.example.parcial_julissa.datamodels.Envio
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class EnvioActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    private var user: FirebaseUser? = null

    private var users: ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_envio)

        val btnEnvios = findViewById<Button>(R.id.btnEnvios)

        btnEnvios.setOnClickListener {
            val intentTres = Intent(this, ResumenActivity::class.java)
            startActivity(intentTres)

            val cuantoEdiitText = 0F
            val saldo: Float = 0F
            val saldoParaEnviar: Float = cuantoEdiitText

            if (saldo > saldoParaEnviar) {
                enviar(saldoParaEnviar)
            }

        }
    }

    private fun DbReference(): DatabaseReference {
        val dbRef = FirebaseDatabase.getInstance().reference
        return dbRef
    }

    private fun enviar(monto: Float) {
        try {
            val dbref = DbReference()
            val key = dbref.child("transacciones").push().key
            val userObject = Envio(user?.uid, monto)
            val postValues = userObject.toMap()
            val childUpdates = HashMap<String, Any>()
            childUpdates["/transacciones/$key"] = postValues
            dbref.updateChildren(childUpdates)
        } catch (ex: Throwable) {
            Toast.makeText(this, "Error${ex.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun DbReference2(): FirebaseDatabase {
        val dbRef = FirebaseDatabase.getInstance()
        return dbRef
    }

    private fun buscarUsuario() {
        try {

            val dbref = DbReference2()
            val usuariosReference = dbref.getReference("Usuarios")

            usuariosReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    val value = dataSnapshot.getValue(User::class.java)!!
                    users.add(value)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        } catch (ex: Throwable) {
        }
    }
}