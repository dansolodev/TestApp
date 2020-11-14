package com.mx.dcc.testapp.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mealEntity: MealCacheEntity): Long

    @Query("SELECT * FROM meals")
    suspend fun getList(): List<MealCacheEntity>

}