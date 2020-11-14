package com.mx.dcc.testapp.domain.repository

import com.mx.dcc.testapp.data.local.entity.Meal
import com.mx.dcc.testapp.data.local.room.CacheMapper
import com.mx.dcc.testapp.data.local.room.MealCacheEntity
import com.mx.dcc.testapp.data.local.room.MealDAO
import com.mx.dcc.testapp.data.network.MealNetworkEntity
import com.mx.dcc.testapp.data.network.MealService
import com.mx.dcc.testapp.data.network.NetworkMapper
import com.mx.dcc.testapp.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MealRepository
constructor(
    private val mealDAO: MealDAO,
    private val mealService: MealService,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getMeals(): Flow<DataState<List<Meal>>> = flow {

        emit(DataState.Loading)

        try {

            val networkMeal: List<MealNetworkEntity> = mealService.getMeals()
            val meals: List<Meal> = networkMapper.fromEntityList(networkMeal)
            for (meal in meals) {
                mealDAO.insert(cacheMapper.mapToEntity(meal))
            }
            val cachedMeal: List<MealCacheEntity> = mealDAO.getList()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedMeal)))

        } catch (e: Exception) {
            e.printStackTrace()
            emit(DataState.Error(e))
        }

    }

}