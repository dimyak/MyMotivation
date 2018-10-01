package com.example.keshl.mymotivation.presentation.creategoal

interface CreateGoalContract {
    interface View

    interface Presenter {
        fun onCreate(view: CreateGoalFragment)
        fun onDestroi()

    }

    interface EvenDelegate


    interface Router
}