package com.mx.dcc.testapp.domain.di

import android.content.Context
import androidx.room.Room
import com.mx.dcc.testapp.data.local.room.MealDAO
import com.mx.dcc.testapp.data.local.room.MealDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideBlogDB(@ApplicationContext context: Context): MealDataBase {

        return Room.databaseBuilder(
            context,
            MealDataBase::class.java,
            MealDataBase.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()

    }

    @Singleton
    @Provides
    fun provideBlogDAO(starWarsDataBase: MealDataBase): MealDAO {

        return starWarsDataBase.mealDAO()

    }

}