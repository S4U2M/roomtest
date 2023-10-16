package com.example.roomtest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomtest.dao.TextDao
import com.example.roomtest.dao.WordDao
import com.example.roomtest.entity.ListEntity
import com.example.roomtest.entity.TextEntity
import com.example.roomtest.entity.WordEntity

@Database(entities = [TextEntity::class,WordEntity::class,ListEntity::class], version = 3)
abstract class TextDatabase : RoomDatabase() {

    abstract fun textDao(): TextDao
    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: TextDatabase? = null

        fun getDatabase(
            context: Context
        ): TextDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDatabase::class.java,
                    "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }

}