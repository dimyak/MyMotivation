package com.example.keshl.mymotivation.presentation.creategoal

import com.example.keshl.mymotivation.domain.GoalModel
import com.example.keshl.mymotivation.presentation.common.BasePresenter

interface CreateGoalContract {
    interface View{
        fun getModel():GoalModel
        fun finish()
    }

    interface Presenter : BasePresenter<View>, EventListener

    interface EventListener {
        fun onSaveGoal()
    }

    interface EvenDelegate


    interface Router{
        fun hideBottomNavigation()
        fun showBottomNavigation()
    }
}