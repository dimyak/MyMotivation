package com.example.keshl.mymotivation.domain.goals

import com.example.keshl.mymotivation.domain.GoalModel
import io.reactivex.Completable
import io.reactivex.Observable

interface GoalsRepository {
    fun getAllGoals(): Observable<List<GoalModel>>
    fun addGoal(model: GoalModel): Completable
}