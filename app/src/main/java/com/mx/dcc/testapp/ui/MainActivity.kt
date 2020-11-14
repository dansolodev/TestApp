package com.mx.dcc.testapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mx.dcc.testapp.R
import com.mx.dcc.testapp.data.local.entity.Meal
import com.mx.dcc.testapp.ui.adapter.MealAdapter
import com.mx.dcc.testapp.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var mealAdapter: MealAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetMealEvent)
    }

    private fun subscribeObservers() {

        viewModel.dataState.observe(this@MainActivity, Observer { dataState ->

            when (dataState) {

                is DataState.Success<List<Meal>> -> {

                    displayProgressBar(false)
                    if (dataState.data.isEmpty()) {
                        displayError(null)
                    } else {
                        displayList(dataState.data)
                    }

                }

                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.localizedMessage)
                }

                is DataState.Loading -> {
                    displayProgressBar(true)
                }

            }

        })

    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun displayError(message: String?) {
        rv_meals.visibility = View.GONE
        text_error.visibility = View.VISIBLE
        text_error.text = message ?: getString(R.string.message_unknown_error)
    }

    private fun displayList(list: List<Meal>) {

        text_error.visibility = View.GONE
        rv_meals.layoutManager = LinearLayoutManager(this@MainActivity)
        mealAdapter = MealAdapter(list) {

        }
        rv_meals.visibility = View.VISIBLE
        rv_meals.adapter = mealAdapter

    }

}