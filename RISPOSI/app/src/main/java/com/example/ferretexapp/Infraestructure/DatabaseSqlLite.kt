package com.example.ferretexapp.Infraestructure

import android.content.Context
import com.example.ferretexapp.Client.Models.Producto

@Database(entities = [Producto::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun productosDao(): ProductoDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java, "app_database").build()

                INSTANCE = instance

                return instance
            }
        }
    }
}