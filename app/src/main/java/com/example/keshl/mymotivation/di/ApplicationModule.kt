package com.example.keshl.mymotivation.di

import dagger.Module
import com.example.keshl.mymotivation.App
import com.example.keshl.mymotivation.di.activity.MainActivityComponent
import android.app.Application
import android.content.Context
import com.example.keshl.mymotivation.data.GoalsDefaultRepository
import com.example.keshl.mymotivation.data.GoalsMemoryStorage
import com.example.keshl.mymotivation.domain.goals.GoalsRepository
import dagger.Binds
import dagger.Provides
import javax.inject.Singleton


@Module(subcomponents = arrayOf(MainActivityComponent::class))
class ApplicationModule (private val baseApp: App){


    @Singleton
    @Provides
    @Binds
    fun provideGoalsMemoryStorage(repository: GoalsMemoryStorage): GoalsRepository {
        return GoalsDefaultRepository(repository)
    }

}

