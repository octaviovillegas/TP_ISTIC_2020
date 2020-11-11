package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_publicaciones__mas__datos.*

class Publicaciones_Mas_Datos : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publicaciones__mas__datos)

        val REQUEST_PHONE_CALL = 1
        //try{

        val UsuPublicaciones = intent.getSerializableExtra("UsuPublicaciones") as Articulo

        var id_pub_imagen_masDatos = UsuPublicaciones.id

        lbl_titulo_pub_usu.text = UsuPublicaciones.titulo
        lbl_categoria_pub_usu.text = UsuPublicaciones.categoria
        lbl_tipo_pub_usu.text = UsuPublicaciones.tipo
        lbl_descripcion_pub_usu.text = UsuPublicaciones.descripcion
        lbl_localidad_pub_usu.text = UsuPublicaciones.localidad
        lbl_codpos_pub_usu.text  = UsuPublicaciones.codiPos
        var num_tel = UsuPublicaciones.telefono

        if (id_pub_imagen_masDatos == 1) {
            imageView_publicacion.setImageResource(R.drawable.imagen_heladera_app)
        }
        if (id_pub_imagen_masDatos == 2) {
            imageView_publicacion.setImageResource(R.drawable.cocina_imagen_app)
        }
        if (id_pub_imagen_masDatos == 3) {
            imageView_publicacion.setImageResource(R.drawable.imagen_mesa_app)
        }
        if (id_pub_imagen_masDatos == 4) {
            imageView_publicacion.setImageResource(R.drawable.imagen_cama_app)
        }
        if (id_pub_imagen_masDatos == 5) {
            imageView_publicacion.setImageResource(R.drawable.imagen_tv2_app)
        }


        //}catch (e:Throwable)
      //  {
       //     Toast.makeText(this, "Error:  ${e.message}",  Toast.LENGTH_SHORT).show()
       // }

        btn_imageButton_llamar.setOnClickListener {

            val llamar = Intent (Intent.ACTION_DIAL)

            llamar.data = Uri.parse("tel:" + num_tel)

            startActivity(llamar)

        }

        btn_volver_PublicMasDatos.setOnClickListener {

            val intent70: Intent = Intent(this, Publicaciones_Usuarios::class.java)

            startActivity(intent70)

            finish()

        }


        btn_imageButton_ubicacion.setOnClickListener {

            val UriIntent= Uri.parse("geo:0,0?q=${lbl_localidad_pub_usu.text}")
            val abrir_mapa=Intent(Intent.ACTION_VIEW,UriIntent)
            abrir_mapa.setPackage("com.google.android.apps.maps")
            startActivity(abrir_mapa)

        }


    }

}


