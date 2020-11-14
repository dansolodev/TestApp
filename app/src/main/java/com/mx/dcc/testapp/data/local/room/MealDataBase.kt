package com.mx.dcc.testapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mx.dcc.testapp.util.Constants

@Database(entities = [MealCacheEntity::class], version = 1)
abstract class MealDataBase : RoomDatabase() {

    abstract fun mealDAO(): MealDAO

    companion object {
        val DATABASE_NAME: String = Constants.DB_NAME
    }

}