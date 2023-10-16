package com.example.roomtest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomtest.entity.ListEntity

@Dao
interface ListDao {

    @Query(value = "SELECT * FROM list_table")
    fun getAllData(): List<ListEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert()

    @Query("DELETE FROM text_table")
    fun deleteAllData()

}