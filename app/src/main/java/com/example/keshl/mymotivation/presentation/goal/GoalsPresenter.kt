package com.example.keshl.mymotivation.presentation.goal

import android.util.Log
import android.view.MenuItem
import android.view.View
import com.example.keshl.mymotivation.R
import javax.inject.Inject

class GoalsPresenter : GoalsContract.Presenter, GoalsContract.Router, GoalsContract.EvenDelegate  {
    override fun onClick(p0: View?) {
        Log.d("MENU","FAB CLICK")
    }

    override fun setGoalFAB(delegate: GoalsContract.EvenDelegate) {
        mRouter.setGoalFAB(this)
    }

    override fun onMenuItemClick(p0: MenuItem?): Boolean {

        val result:Boolean = when{
            R.id.nav_new == p0?.itemId-> itemNew()
            R.id.nav_important == p0?.itemId ->itemImportant()
            else -> false
        }
        return result
    }

    private fun itemNew():Boolean{
        Log.d("MENU","NAV_NEW")
        return true
    }
    private fun itemImportant():Boolean{
        Log.d("MENU","NAV_IMPORTANT")
        return true
    }


    lateinit var mRouter: GoalsContract.Router

    @Inject
    constructor(router: GoalsContract.Router) {
        mRouter = router
    }

    lateinit var mView: GoalsContract.View

    override fun onCreate(view: GoalsFragment) {
        mView = view
        setGoalFAB(this)

    }

    override fun onDestroi() {

    }


}