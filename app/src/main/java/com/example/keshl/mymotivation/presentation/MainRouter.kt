package com.example.keshl.mymotivation.presentation

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.keshl.mymotivation.R
import com.example.keshl.mymotivation.di.activity.ActivityScope
import com.example.keshl.mymotivation.presentation.goal.GoalsContract
import com.example.keshl.mymotivation.presentation.goal.GoalsFragment
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

@ActivityScope
class MainRouter : GoalsContract.Router{
    @SuppressLint("RestrictedApi")
    override fun setGoalFAB(delegate:GoalsContract.EvenDelegate) {
        mActivity.fab.setImageResource(R.drawable.ic_add_white)
        mActivity.fab.visibility = View.VISIBLE
        mActivity.fab.setOnClickListener(delegate)

        setGoalToolBarMenu(delegate)
    }

    private fun setGoalToolBarMenu(delegate:GoalsContract.EvenDelegate){
        mActivity.toolbar.inflateMenu(R.menu.goal_fragment_menu)
        mActivity.toolbar.setOnMenuItemClickListener(delegate)
    }

    private val mActivity:AppCompatActivity
    private lateinit var mCurrentFragment:Fragment

    @Inject
    constructor(appCompatActivity: AppCompatActivity){
        mActivity = appCompatActivity
    }


    fun navigateToGoalsFragment(){
        replaceWithoutBackStack(GoalsFragment.newInstance())
    }

    private fun setCurrentFragment(fragment: Fragment) {
        mCurrentFragment = fragment
    }

    private fun replaceWithoutBackStack(fragment: Fragment) {
        setCurrentFragment(fragment)

        mActivity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainContainer, fragment)
                .commit()
    }
}