package com.example.ferretexapp.Infraestructure

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ferretexapp.Client.Models.Producto
import com.example.ferretexapp.Infraestructure.Interface.ProductoDao

@Database(entities = [Producto::class], version = 1)
abstract class DatabaseSqlLite : RoomDatabase(){
    abstract fun productosDao(): ProductoDao

    companion object{
        @Volatile
        private var INSTANCE: DatabaseSqlLite? = null

        fun getDatabase(context: Context): DatabaseSqlLite{
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,DatabaseSqlLite::class.java, "app_database").build()

                INSTANCE = instance

                return instance
            }
        }
    }
}