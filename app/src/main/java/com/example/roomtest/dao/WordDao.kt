package com.example.roomtest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomtest.entity.WordEntity

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table")
    fun getAllData() : List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(text : WordEntity)

    @Query("DELETE FROM word_table")
    fun deleteAllData()

    @Query("DELETE FROM word_table WHERE id = :wordId")
    fun deleteWordFromId(wordId: Int)

}