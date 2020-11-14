package com.mx.dcc.testapp.domain.di

import com.mx.dcc.testapp.data.local.room.CacheMapper
import com.mx.dcc.testapp.data.local.room.MealDAO
import com.mx.dcc.testapp.data.network.MealService
import com.mx.dcc.testapp.data.network.NetworkMapper
import com.mx.dcc.testapp.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideSWRepository(
        mealDAO: MealDAO,
        service: MealService,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MealRepository {

        return MealRepository(mealDAO, service, cacheMapper, networkMapper)

    }

}