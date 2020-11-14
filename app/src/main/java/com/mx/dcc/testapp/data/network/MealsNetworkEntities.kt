package com.mx.dcc.testapp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MealsNetworkEntities(
    @SerializedName("meals")
    @Expose
    val meals: List<MealNetworkEntity>
)