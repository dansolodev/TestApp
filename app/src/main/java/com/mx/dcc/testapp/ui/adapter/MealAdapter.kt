package com.mx.dcc.testapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mx.dcc.testapp.R
import com.mx.dcc.testapp.data.local.entity.Meal
import com.mx.dcc.testapp.util.inflate
import com.mx.dcc.testapp.util.loadImageByURL
import kotlinx.android.synthetic.main.item_list.view.*

class MealAdapter(
    private val items: List<Meal>,
    private val listener: (Meal) -> Unit
) : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        this.mContext = parent.context
        return MealViewHolder(parent.inflate(R.layout.item_list, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    inner class MealViewHolder(private val mItemView: View) : RecyclerView.ViewHolder(mItemView) {

        fun bind(item: Meal, listener: (Meal) -> Unit) = with(mItemView) {
            iv_meal.loadImageByURL(item.mealThumb, mContext)
            tv_meal_name.text = item.nameMeal
            tv_meal_category.text = item.category
            setOnClickListener{ listener(item) }
        }

    }

}