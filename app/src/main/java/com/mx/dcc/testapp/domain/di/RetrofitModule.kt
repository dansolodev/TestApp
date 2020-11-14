package com.mx.dcc.testapp.domain.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mx.dcc.testapp.data.network.MealService
import com.mx.dcc.testapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun providerGsonBuilder(): Gson {

        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))

    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit.Builder): MealService {

        return retrofit
            .build()
            .create(MealService::class.java)

    }

}