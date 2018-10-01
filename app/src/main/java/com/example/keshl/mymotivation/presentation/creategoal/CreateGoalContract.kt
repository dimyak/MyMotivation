package com.example.keshl.mymotivation.presentation.creategoal

import com.example.keshl.mymotivation.presentation.common.BasePresenter

interface CreateGoalContract {
    interface View

    interface Presenter : BasePresenter<View>

    interface EvenDelegate


    interface Router{
        fun hideBottomNavigation()
        fun showBottomNavigation()
    }
}