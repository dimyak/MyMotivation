package com.example.keshl.mymotivation.presentation.goal

import javax.inject.Inject

class GoalsPresenter : GoalsContract.Presenter, GoalsContract.Router, GoalsContract.EvenDelegate {

    private lateinit var mView: GoalsContract.View
    private val mRouter: GoalsContract.Router

    @Inject
    constructor(router: GoalsContract.Router) {
        mRouter = router
    }


    override fun onCreateView(v: GoalsContract.View) {
        mView = v
    }

    override fun onDestroy() {

    }

    override fun createNewGoal() {
        navigateToCreateGoalFragment()
    }

    override fun navigateToCreateGoalFragment() {
        mRouter.navigateToCreateGoalFragment()
    }


}