package com.example.keshl.mymotivation.presentation.goal

interface GoalsContract {

    interface View

    interface Presenter {

        fun onCreate(view: GoalsFragment)
        fun onDestroi()
        fun createNewGoal()

    }

    interface EvenDelegate


    interface Router {
        fun navigateToCreateGoalFragment()
    }


}
