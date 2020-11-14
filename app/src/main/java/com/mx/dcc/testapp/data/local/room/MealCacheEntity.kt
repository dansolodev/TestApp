package com.mx.dcc.testapp.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "nameMeal")
    var nameMeal: String,
    @ColumnInfo(name = "category")
    var category: String,
    @ColumnInfo(name = "mealThumb")
    var mealThumb: String,
    @ColumnInfo(name = "youtubeVideo")
    var youtubeVideo: String

)