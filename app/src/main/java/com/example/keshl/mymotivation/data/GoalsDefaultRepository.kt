package com.example.keshl.mymotivation.data

import com.example.keshl.mymotivation.domain.GoalModel
import com.example.keshl.mymotivation.domain.goals.GoalsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoalsDefaultRepository : GoalsRepository {
    private val mMemoryStorage: GoalsMemoryStorage

    @Inject
    constructor(memoryStorage: GoalsMemoryStorage) {
        mMemoryStorage = memoryStorage
    }

    override fun getAllGoals(): Observable<List<GoalModel>> =
            mMemoryStorage.getAllGoals()

    override fun addGoal(model: GoalModel): Completable =
            mMemoryStorage.addGoal(model)

}