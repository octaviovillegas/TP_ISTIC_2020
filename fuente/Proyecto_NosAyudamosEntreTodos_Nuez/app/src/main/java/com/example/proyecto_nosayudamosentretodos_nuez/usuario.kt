package com.example.proyecto_nosayudamosentretodos_nuez

import android.content.ContentValues
import android.content.Context
import android.widget.Toast

class usuario {

    var id:Int=0
    var nombre:String=""
    var clave:String=""
    var email:String=""
    constructor(nombre:String,clave:String,email:String)
    {
        this.nombre=nombre
        this.clave=clave
        this.email=email
    }


    companion object{


        fun retornarArrayUsuarios(contexto: Context): MutableList<String> {
            val listado: MutableList<String> = ArrayList()
            val admin = Base_Datos(contexto, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select id,nombre,clave from usuarios", null)
            if (fila.moveToFirst()) {

                do {
                    val id: String = fila.getString(0)
                    val nombre: String = fila.getString(1)
                    val clave: String = fila.getString(2)
                    listado.add(id +" "+nombre+" "+clave)
                } while (fila.moveToNext())

            } else{
                Toast.makeText(contexto, "No hay usuarios",  Toast.LENGTH_SHORT).show()
            }
            bd.close()
            return listado
        }
    }


    public fun GuardarEnSqLite(contexto: Context): Long {
        var retorno:Long= 0L
        try {
            val admin = Base_Datos(contexto,"SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre",this.nombre)
            registro.put("clave",this.clave)
            registro.put("email",this.email)
            retorno=bd.insert("usuarios", null, registro)
            bd.close()
            //esto lo comento para que no salga este mensaje en el registro
            //Toast.makeText(contexto, "se creo el ID: $retorno", Toast.LENGTH_SHORT).show()
        }catch (e:Throwable)
        {
            Toast.makeText(contexto, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
        return retorno
    }

    public fun ActualizarEnSqLite(contexto: Context): Long {
        var retorno:Long= 0L
        try {
            val admin = Base_Datos(contexto,"SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre",this.nombre)
            registro.put("clave",this.clave)
            retorno=bd.insert("usuarios", null, registro)
            bd.close()
            Toast.makeText(contexto, "se creo el ID: $retorno", Toast.LENGTH_SHORT).show()
        }catch (e:Throwable)
        {
            Toast.makeText(contexto, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
        return retorno
    }

}