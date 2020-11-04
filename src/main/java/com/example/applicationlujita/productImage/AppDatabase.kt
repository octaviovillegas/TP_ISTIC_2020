package com.example.applicationlujita.productImage

import android.content.Context
import androidx.room.Database
import androidx.room.Room

@Database(entities = [Producto::class], version = 1)
abstract class AppDatabase : androidx.room.RoomDatabase() {

    abstract fun productos(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }
}