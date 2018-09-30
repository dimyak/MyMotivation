package com.example.keshl.mymotivation.di

import dagger.Module
import com.example.keshl.mymotivation.App
import com.example.keshl.mymotivation.di.activity.MainActivityComponent

@Module(subcomponents = arrayOf(MainActivityComponent::class))
class ApplicationModule (private val baseApp: App){



}

