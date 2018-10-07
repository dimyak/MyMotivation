package com.example.keshl.mymotivation.presentation.goal

import com.example.keshl.mymotivation.domain.GoalModel
import com.example.keshl.mymotivation.presentation.common.BasePresenter

interface GoalsContract {

    interface View

    interface Presenter : BasePresenter<View>, EventListener {
        fun createNewGoal()
    }

    interface EventListener {
        fun onGoalClick(model: GoalModel)
    }

    interface EvenDelegate


    interface Router {
        fun navigateToCreateGoalFragment()
    }


}
