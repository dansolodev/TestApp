package com.mx.dcc.testapp.data.network

import com.mx.dcc.testapp.data.local.entity.Meal
import com.mx.dcc.testapp.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<MealNetworkEntity, Meal> {

    override fun mapFromEntity(entity: MealNetworkEntity): Meal {

        return Meal(

            id = entity.id,
            nameMeal = entity.nameMeal,
            category = entity.category,
            mealThumb = entity.mealThumb,
            youtubeVideo = entity.youtubeVideo

        )

    }

    override fun mapToEntity(domainModel: Meal): MealNetworkEntity {
        return MealNetworkEntity(

            id = domainModel.id,
            nameMeal = domainModel.nameMeal,
            category = domainModel.category,
            mealThumb = domainModel.mealThumb,
            youtubeVideo = domainModel.youtubeVideo

        )
    }

    fun fromEntityList(entities: List<MealNetworkEntity>) : List<Meal> {
        return entities.map { mapFromEntity(it) }
    }

}