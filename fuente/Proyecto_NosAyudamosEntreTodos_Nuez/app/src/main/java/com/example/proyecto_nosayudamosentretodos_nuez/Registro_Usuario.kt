package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro__usuario.*

class Registro_Usuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro__usuario)


        btn_registrarse.setOnClickListener {

            if (lbl_usuario_del_registro.text.toString()
                    .isEmpty() or lbl_contra_registro.text.toString()
                    .isEmpty() or lbl_repita_contra_registro.text.toString().isEmpty() or
                     lbl_email_registro.text.toString().isEmpty()
            ) {

                Toast.makeText(this, "hay campos sin completar ", Toast.LENGTH_LONG).show()
            } else {
                if (lbl_contra_registro.text.toString() != lbl_repita_contra_registro.text.toString()) {

                    Toast.makeText(this, "las contraseñas son diferentes ", Toast.LENGTH_LONG)
                        .show()
                } else {

                    altaDeUsuario()
                }
            }
        }

        btn_volver_registro.setOnClickListener {

            val intent52: Intent = Intent(this, MainActivity::class.java)

            startActivity(intent52)

            finish()

        }
    }


    private fun altaDeUsuario(): Long {
        var retorno:Long= 0L

        if(this.lbl_usuario_del_registro.toString().isNotEmpty()&&this.lbl_contra_registro.toString().isNotEmpty() )
        {

            var nombre=this.lbl_usuario_del_registro.getText().toString()
            var clave=this.lbl_contra_registro.getText().toString()
            var email=this.lbl_email_registro.getText().toString()
            val miUsuario= usuario(nombre,clave,email)
            retorno=miUsuario.GuardarEnSqLite(this)

            val intent2: Intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this, "Usuario registrado con exito", Toast.LENGTH_SHORT).show()
            startActivity(intent2)

            finish()

        }else
        {
            Toast.makeText(this, "Los campos no deben estar vacios", Toast.LENGTH_SHORT).show()
        }
        return retorno
    }
}
