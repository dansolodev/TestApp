package com.mx.dcc.testapp.data.local.room

import com.mx.dcc.testapp.data.local.entity.Meal
import com.mx.dcc.testapp.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<MealCacheEntity, Meal> {

    override fun mapFromEntity(entity: MealCacheEntity): Meal {

        return Meal(

            id = entity.id,
            nameMeal = entity.nameMeal,
            category = entity.category,
            mealThumb = entity.mealThumb,
            youtubeVideo = entity.youtubeVideo

        )

    }

    override fun mapToEntity(domainModel: Meal): MealCacheEntity {

        return MealCacheEntity(

            id = domainModel.id,
            nameMeal = domainModel.nameMeal,
            category = domainModel.category,
            mealThumb = domainModel.mealThumb,
            youtubeVideo = domainModel.youtubeVideo

        )

    }

    fun mapFromEntityList(entities: List<MealCacheEntity>) : List<Meal> {
        return entities.map { mapFromEntity(it) }
    }

}