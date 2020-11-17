package com.example.proyecto_nosayudamosentretodos_nuez

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_subir__publicacion.*
import java.io.File

class Subir_Publicacion : AppCompatActivity() {

    val REQUEST_CAMERA = 1002

    var foto: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subir__publicacion)


        btn_foto.setOnClickListener {

            abre_Camara_Click()
        }

        btn_publicar.setOnClickListener {

            altaPublicacion()

        }

        btn_volver_SubirPublicacion.setOnClickListener {

            val intent42: Intent = Intent(this, Perfil_Usuario::class.java)

            startActivity(intent42)

            finish()

        }



    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CAMERA ->{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    usar_Camara()
                } else{
                    Toast.makeText(applicationContext,  " no podes acceder a la camera", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun abre_Camara_Click(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
                || checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){

                val permiso_uso_Camara = arrayOf(android.Manifest.permission.CAMERA , android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(permiso_uso_Camara, REQUEST_CAMERA)
            }else{
                usar_Camara()
            }
        }else{
            usar_Camara()
        }

    }


    fun usar_Camara(){

        val value = ContentValues()
        value.put(MediaStore.Images.Media.TITLE, "nueva foto")
        foto=contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,value)
        val camaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        camaraIntent.putExtra(MediaStore.EXTRA_OUTPUT, foto)
        startActivityForResult(camaraIntent,REQUEST_CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CAMERA){
            imageView_foto.setImageURI(foto)
        }

    }

    private fun altaPublicacion(){
        //var retorno:Long= 0L
        if(this.lbl_tituño_pub.getText().isNotEmpty() && this.lbl_categoria_pub.getText().isNotEmpty() && this.lbl_tipo_pub.getText().isNotEmpty()
            && this.lbl_descripcion_pub.getText().isNotEmpty() && this.lbl_localidad_pub.getText().isNotEmpty()
            && this.lbl_codpos_pub.getText().isNotEmpty() && this.lbl_telefono_pub.getText().isNotEmpty())
        {

            var titulo=this.lbl_tituño_pub.getText().toString()
            var categoria=this.lbl_categoria_pub.getText().toString()
            var tipo=this.lbl_tipo_pub.getText().toString()
            var descripcion=this.lbl_descripcion_pub.getText().toString()
            var localidad=this.lbl_localidad_pub.getText().toString()
            var codipost=this.lbl_codpos_pub.getText().toString()
            var telefono=this.lbl_telefono_pub.getText().toString()


            try {
                val admin = Base_Datos(this,"SqLite2020", null, 2)
                val bd = admin.writableDatabase
                val registro = ContentValues()
                registro.put("titulo",titulo)
                registro.put("categoria",categoria)
                registro.put("tipo",tipo)
                registro.put("descripcion",descripcion)
                registro.put("localidad",localidad)
                registro.put("codipos",codipost)
                registro.put("telefono",telefono)
                bd.insert("MisArticulos", null, registro)
                //retorno= newId
                bd.close()
                Toast.makeText(this, "la publicacion se subio con exito", Toast.LENGTH_SHORT).show()

                val intent47: Intent = Intent(this, Mis_Articulos::class.java)

                startActivity(intent47)

                finish()

            }catch (e:Throwable)
            {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }


        }else
        {
            Toast.makeText(this, "Los campos no deben estar vacios", Toast.LENGTH_SHORT).show()
        }
        //return retorno
    }
}
