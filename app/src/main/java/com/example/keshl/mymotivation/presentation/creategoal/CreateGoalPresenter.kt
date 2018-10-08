package com.example.keshl.mymotivation.presentation.creategoal

import android.util.Log
import com.example.keshl.mymotivation.domain.goals.GoalsInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class CreateGoalPresenter : CreateGoalContract.Presenter, CreateGoalContract.Router{
    private val mRouter: CreateGoalContract.Router

    private val mInteractor:GoalsInteractor

    private lateinit var mView: CreateGoalContract.View
    @Inject
    constructor(router: CreateGoalContract.Router,
                interactor: GoalsInteractor) {
        mRouter = router
        mInteractor = interactor
    }
    override fun onCreateView(v: CreateGoalContract.View) {
        mView = v
        hideBottomNavigation()
    }

    override fun onDestroy() {
        mRouter.showBottomNavigation()
    }

    override fun onSaveGoal() {
        mInteractor.addGoal(mView.getModel())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    mView?.finish()
                    Log.d("DOWNLOAD", "save")
                }

    }



    override fun hideBottomNavigation() {
        mRouter.hideBottomNavigation()
    }

    override fun showBottomNavigation() {
        mRouter.showBottomNavigation()
    }


}
