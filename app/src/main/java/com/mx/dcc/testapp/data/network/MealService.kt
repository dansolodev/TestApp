package com.mx.dcc.testapp.data.network

import retrofit2.http.GET

interface MealService {
    @GET("search.php?s")
    suspend fun getMeals(): List<MealNetworkEntity>
}