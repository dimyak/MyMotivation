package com.example.keshl.mymotivation.domain

import io.realm.RealmObject
import javax.inject.Inject

open class GoalModel(var title: String,
                     var description: String) : RealmObject() {
    @Inject
    constructor() : this(title = "title", description = "description")

}