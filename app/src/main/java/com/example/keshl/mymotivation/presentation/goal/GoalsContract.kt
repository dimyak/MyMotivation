package com.example.keshl.mymotivation.presentation.goal

import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View

interface GoalsContract {

    interface View {

    }

    interface Presenter {

        fun onCreate(view:GoalsFragment)
        fun onDestroi()

    }

    interface EvenDelegate:  Toolbar.OnMenuItemClickListener, android.view.View.OnClickListener{

    }


    interface Router{
        fun setGoalFAB(delegate:GoalsContract.EvenDelegate)
    }


}
