package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.AppTheme2)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_ingresar_login.setOnClickListener {

            if (lbl_usuario_login.text.toString().isEmpty() or lbl_contrasena_login.text.toString()
                    .isEmpty()
            ) {

                Toast.makeText(this, "hay campos sin completar ", Toast.LENGTH_LONG).show()
            } else {

                Login_Usuario()

            }
        }

        btn_registro_usuario.setOnClickListener {

            val intent: Intent = Intent(this,Registro_Usuario::class.java)
            startActivity(intent)
            finish()

        }

    }

    fun Login_Usuario() {

        try {
            var bandera: String = "no"

            val admin = Base_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,clave from usuarios", null)

            if (fila.moveToFirst()) {
                do {
                    val nombre: String = fila.getString(0)
                    val clave: String = fila.getString(1)

                    if (lbl_usuario_login.text.toString() == nombre && lbl_contrasena_login.text.toString() == clave) {

                        bandera = "si"

                        Toast.makeText(this, "bienvenido  " + nombre , Toast.LENGTH_LONG).show()
                        val Usuario_Logueado = lbl_usuario_login.text.toString()
                        val intent3: Intent = Intent(this, Perfil_Usuario::class.java)
                        intent3.putExtra("nombre", Usuario_Logueado)
                        startActivity(intent3)

                        finish()
                    }

                } while (fila.moveToNext())

                if (bandera == "no") {
                    Toast.makeText(this, "Usuario y/o contraseña incorecto ", Toast.LENGTH_LONG)
                        .show()
                }

            }else{
                Toast.makeText(this, "no estas registrado? REGISTRATE!!!! ", Toast.LENGTH_LONG)
                    .show()
            }
            bd.close()

        } catch (e: Throwable) {
            Toast.makeText(this, "debes registrarte ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

}

/*

fun Login_Usuario() {


        try {
            var bandera: String = "no"

            val admin = Base_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,clave from usuarios", null)


            if (fila.moveToFirst()) {
                do {
                    val nombre: String = fila.getString(0)
                    val clave: String = fila.getString(1)

                    if (lbl_usuario_login.text.toString() == nombre && lbl_contrasena_login.text.toString() == clave) {

                        bandera = "si"

                        val Usuario_Logueado = lbl_usuario_login.text.toString()
                        val intent3: Intent = Intent(this, Perfil_Usuario::class.java)
                        intent3.putExtra("nombre", Usuario_Logueado)
                        startActivity(intent3)

                        finish()
                    }

                } while (fila.moveToNext())

                if (bandera == "no") {
                    Toast.makeText(this, "Usuario y/o contraseña incorecto ", Toast.LENGTH_LONG)
                        .show()
                }
            }
            bd.close()

        } catch (e: Throwable) {
            Toast.makeText(this, "debes registrarte ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

 */

/*
  fun Login_Usuario() {


        try {
            val admin = Base_Datos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select nombre,clave from usuarios", null)
            if (fila.moveToFirst()) {
                do {
                    val nombre: String = fila.getString(0)
                    val clave: String = fila.getString(1)

                    if (lbl_usuario_login.text.toString() == nombre && lbl_contrasena_login.text.toString() == clave) {

                        val Usuario_Logueado = lbl_usuario_login.text.toString()
                        val intent3: Intent = Intent(this, Perfil_Usuario::class.java)
                        intent3.putExtra("nombre", Usuario_Logueado)
                        startActivity(intent3)

                        finish()
                    }

                } while (fila.moveToNext())

            }else {
                Toast.makeText(this, "Usuario y/o contraseña incorecto ", Toast.LENGTH_LONG)
                    .show()
            }
            bd.close()

        }catch (e: Throwable) {
            Toast.makeText(this, "debes registrarte ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
 */