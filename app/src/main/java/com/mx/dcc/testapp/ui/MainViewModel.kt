package com.mx.dcc.testapp.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.mx.dcc.testapp.data.local.entity.Meal
import com.mx.dcc.testapp.domain.repository.MealRepository
import com.mx.dcc.testapp.util.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel
@ViewModelInject
constructor(
    private val mealRepository: MealRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Meal>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Meal>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {

        viewModelScope.launch {

            when(mainStateEvent) {

                is MainStateEvent.GetMealEvent -> {
                    mealRepository.getMeals()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }


            }

        }

    }

}

sealed class  MainStateEvent {
    object GetMealEvent : MainStateEvent()
    object None : MainStateEvent()
}