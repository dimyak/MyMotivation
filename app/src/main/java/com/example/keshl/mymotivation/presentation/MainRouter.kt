package com.example.keshl.mymotivation.presentation

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.keshl.mymotivation.R
import com.example.keshl.mymotivation.di.activity.ActivityScope
import com.example.keshl.mymotivation.presentation.creategoal.CreateGoalContract
import com.example.keshl.mymotivation.presentation.creategoal.CreateGoalFragment
import com.example.keshl.mymotivation.presentation.goal.GoalsContract
import com.example.keshl.mymotivation.presentation.goal.GoalsFragment
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

@ActivityScope
class MainRouter : GoalsContract.Router,
        CreateGoalContract.Router {
    private val mActivity:MainActivity

    private lateinit var mCurrentFragment:Fragment


    @Inject
    constructor(appCompatActivity: MainActivity){
        mActivity = appCompatActivity
    }
    override fun showBottomNavigation() {
        mActivity.showBottomNavigation()
    }

    override fun hideBottomNavigation() {
        mActivity.hideBottomNavigation()
    }

    override fun navigateToCreateGoalFragment() {
        replaceWithBackStack(CreateGoalFragment.newInstance())
    }



    fun navigateToGoalsFragment(){
        clearBackStack()
        replaceWithoutBackStack(GoalsFragment.newInstance())
    }

    private fun setCurrentFragment(fragment: Fragment) {
        mCurrentFragment = fragment
    }

    private fun clearBackStack() {
        val fm:FragmentManager  = mActivity.supportFragmentManager
        for (i in 0..fm.backStackEntryCount)
            fm.popBackStack()
    }


    private fun replaceWithoutBackStack(fragment: Fragment) {
        setCurrentFragment(fragment)

        mActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainContainer, fragment, fragment.javaClass.simpleName)
                .commit()
    }

    private fun replaceWithBackStack(fragment: Fragment) {
        setCurrentFragment(fragment)

        mActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainContainer, fragment, fragment.javaClass.simpleName)
                .addToBackStack(fragment.javaClass.simpleName)
                .commit()
    }
}