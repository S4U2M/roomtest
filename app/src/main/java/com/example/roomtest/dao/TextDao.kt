package com.example.roomtest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomtest.entity.TextEntity

@Dao
interface TextDao {
    @Query(value = "SELECT * FROM text_table")
    fun getAllData() : List<TextEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(textEntity: TextEntity)

    @Query("DELETE FROM text_table")
    fun deleteAllData()
}