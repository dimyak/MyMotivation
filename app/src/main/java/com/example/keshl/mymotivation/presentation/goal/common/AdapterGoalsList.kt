package com.example.keshl.mymotivation.presentation.goal.common

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.keshl.mymotivation.R
import com.example.keshl.mymotivation.domain.GoalModel
import com.example.keshl.mymotivation.presentation.goal.GoalsContract

class AdapterGoalsList(private val listener: GoalsContract.EventListener) : RecyclerView.Adapter<GoalViewHolder>() {
    private var mListGoals: List<GoalModel> = emptyList()

    fun setGoalList(list: List<GoalModel>) {
        mListGoals = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(p0: GoalViewHolder, p1: Int) {
        p0.bind(mListGoals[p1], listener)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GoalViewHolder {
        var view = LayoutInflater.from(p0.context)
                .inflate(R.layout.item_goal, p0, false)
        return GoalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mListGoals.size
    }


}