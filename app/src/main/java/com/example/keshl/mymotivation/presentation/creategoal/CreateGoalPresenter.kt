package com.example.keshl.mymotivation.presentation.creategoal

import javax.inject.Inject

class CreateGoalPresenter : CreateGoalContract.Presenter, CreateGoalContract.Router {
    private val mRouter: CreateGoalContract.Router

    private lateinit var mView: CreateGoalContract.View

    @Inject
    constructor(router: CreateGoalContract.Router) {
        mRouter = router
    }
    override fun onCreateView(v: CreateGoalContract.View) {
        mView = v
        hideBottomNavigation()
    }


    override fun onDestroy() {
        mRouter.showBottomNavigation()
    }

    override fun hideBottomNavigation() {
        mRouter.hideBottomNavigation()
    }

    override fun showBottomNavigation() {
        mRouter.showBottomNavigation()
    }


}
