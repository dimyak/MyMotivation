package com.example.keshl.mymotivation.presentation.goal

import android.util.Log
import android.view.MenuItem
import android.view.View
import com.example.keshl.mymotivation.R
import javax.inject.Inject

class GoalsPresenter : GoalsContract.Presenter, GoalsContract.Router, GoalsContract.EvenDelegate  {




    lateinit var mRouter: GoalsContract.Router

    @Inject
    constructor(router: GoalsContract.Router) {
        mRouter = router
    }

    lateinit var mView: GoalsContract.View

    override fun onCreate(view: GoalsFragment) {
        mView = view


    }

    override fun onDestroi() {

    }

    override fun createNewGoal() {
        navigateToCreateGoalFragment()
    }

    override fun navigateToCreateGoalFragment() {
        mRouter.navigateToCreateGoalFragment()
    }



}