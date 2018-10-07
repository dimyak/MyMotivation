package com.example.keshl.mymotivation.presentation.goal.common

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.keshl.mymotivation.databinding.ItemGoalBinding
import com.example.keshl.mymotivation.domain.GoalModel
import com.example.keshl.mymotivation.presentation.goal.GoalsContract

class GoalViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    private val mBinding: ItemGoalBinding =
            DataBindingUtil.bind<ItemGoalBinding>(v)!!


    fun bind(model: GoalModel
             , listener: GoalsContract.EventListener) {
        mBinding.goal = model
        mBinding.event = listener

    }
}