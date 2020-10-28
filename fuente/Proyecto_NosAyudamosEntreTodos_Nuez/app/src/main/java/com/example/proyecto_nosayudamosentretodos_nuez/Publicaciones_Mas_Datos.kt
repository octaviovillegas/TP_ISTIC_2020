package com.example.proyecto_nosayudamosentretodos_nuez

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_publicaciones__mas__datos.*

class Publicaciones_Mas_Datos : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publicaciones__mas__datos)

        val REQUEST_PHONE_CALL = 1
        //try{

        val UsuPublicaciones = intent.getSerializableExtra("UsuPublicaciones") as Articulo

        lbl_titulo_pub_usu.text = UsuPublicaciones.titulo
        lbl_categoria_pub_usu.text = UsuPublicaciones.categoria
        lbl_tipo_pub_usu.text = UsuPublicaciones.tipo
        lbl_descripcion_pub_usu.text = UsuPublicaciones.descripcion
        lbl_localidad_pub_usu.text = UsuPublicaciones.localidad
        lbl_codpos_pub_usu.text  = UsuPublicaciones.codiPos
        var num_tel = UsuPublicaciones.telefono


        //}catch (e:Throwable)
      //  {
       //     Toast.makeText(this, "Error:  ${e.message}",  Toast.LENGTH_SHORT).show()
       // }

        btn_imageButton.setOnClickListener {

            val llamar = Intent (Intent.ACTION_DIAL)

            llamar.data = Uri.parse("tel:" + num_tel)

            startActivity(llamar)

        }

        btn_volver_PublicMasDatos.setOnClickListener {

            val intent70: Intent = Intent(this, Publicaciones_Usuarios::class.java)

            startActivity(intent70)

            finish()

        }

    }

}


