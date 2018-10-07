package com.example.keshl.mymotivation.domain.goals

import com.example.keshl.mymotivation.data.GoalsDefaultRepository
import com.example.keshl.mymotivation.domain.GoalModel
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class GoalsInteractor {

    private val mGoalsRepository: GoalsDefaultRepository

    @Inject
    constructor(goalsDefaultRepository: GoalsDefaultRepository) {
        mGoalsRepository = goalsDefaultRepository
    }

    fun getAllGoals(): Observable<List<GoalModel>> = mGoalsRepository.getAllGoals()
    fun addGoal(model: GoalModel): Completable = mGoalsRepository.addGoal(model)
}