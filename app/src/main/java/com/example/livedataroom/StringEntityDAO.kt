package com.example.livedataroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StringEntityDAO {
    @Query("SELECT * FROM string_table ORDER BY id DESC LIMIT 1")
    fun getLastData():LiveData<StringEntity>                        //Берем из БД

    @Insert(onConflict = OnConflictStrategy.REPLACE)                //Кладем в БД
    fun putData(stringEntity: StringEntity)
}