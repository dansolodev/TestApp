package com.mx.dcc.testapp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MealNetworkEntity(
    @SerializedName("idMeal")
    @Expose
    var id: String,
    @SerializedName("strMeal")
    @Expose
    var nameMeal: String,
    @SerializedName("strCategory")
    @Expose
    var category: String,
    @SerializedName("strMealThumb")
    @Expose
    var mealThumb: String,
    @SerializedName("strYoutube")
    @Expose
    var youtubeVideo: String
)