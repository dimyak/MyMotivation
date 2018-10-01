package com.example.keshl.mymotivation.presentation.creategoal

import javax.inject.Inject

class CreateGoalPresenter : CreateGoalContract.Presenter, CreateGoalContract.Router {


    lateinit var mRouter: CreateGoalContract.Router

    @Inject
    constructor(router: CreateGoalContract.Router) {
        mRouter = router
    }

    lateinit var mView: CreateGoalContract.View

    override fun onCreate(view: CreateGoalFragment) {
        mView = view

    }

    override fun onDestroi() {

    }


}