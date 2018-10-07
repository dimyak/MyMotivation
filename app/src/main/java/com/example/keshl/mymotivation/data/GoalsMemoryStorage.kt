package com.example.keshl.mymotivation.data

import android.content.Context
import com.example.keshl.mymotivation.domain.GoalModel
import com.example.keshl.mymotivation.domain.goals.GoalsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where
import javax.inject.Inject
import javax.inject.Singleton


class GoalsMemoryStorage : GoalsRepository {
    private val mContext: Context

    @Inject
    constructor(context: Context) {
        mContext = context
    }


    override fun getAllGoals(): Observable<List<GoalModel>> {
        val listGoals = getRealm().where(GoalModel::class.java).findAll()
        return Observable.just(getRealm().copyFromRealm(listGoals))
    }

    override fun addGoal(model: GoalModel): Completable {
        return Completable.create { e ->
            getRealm().executeTransaction { realm: Realm ->
                realm.copyToRealm(model)
                e.onComplete()
            }
        }
    }

    private fun getRealm(): Realm = Realm.getDefaultInstance()

}