package com.example.keshl.mymotivation.presentation.goal

import com.example.keshl.mymotivation.presentation.common.BasePresenter

interface GoalsContract {

    interface View

    interface Presenter: BasePresenter<View> {
        fun createNewGoal()
    }

    interface EvenDelegate


    interface Router {
        fun navigateToCreateGoalFragment()
    }


}
