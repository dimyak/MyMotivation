package com.example.keshl.mymotivation.presentation.goal

import android.util.Log
import com.example.keshl.mymotivation.domain.GoalModel
import com.example.keshl.mymotivation.domain.goals.GoalsInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GoalsPresenter : GoalsContract.Presenter, GoalsContract.Router, GoalsContract.EventListener {
    private lateinit var mView: GoalsContract.View
    private val mRouter: GoalsContract.Router
    private val mInteractor: GoalsInteractor


    @Inject
    constructor(router: GoalsContract.Router,
                interactor: GoalsInteractor) {
        mRouter = router
        mInteractor = interactor
    }

    override fun onGoalClick(model: GoalModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreateView(v: GoalsContract.View) {
        mView = v
        mInteractor.getAllGoals()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("DOWNLOAD", it.size.toString())
                    mView?.setGoalList(it)
                }
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