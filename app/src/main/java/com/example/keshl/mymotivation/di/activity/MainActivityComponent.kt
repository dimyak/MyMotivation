package com.example.keshl.mymotivation.di.activity

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.keshl.mymotivation.ACTIVITY_CONTEXT
import com.example.keshl.mymotivation.presentation.MainActivity
import com.example.keshl.mymotivation.presentation.goal.GoalsFragment
import com.example.keshl.mymotivation.presentation.goal.GoalsFragmentComponent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import javax.inject.Named

@ActivityScope
@Subcomponent(
        modules = arrayOf(
                MainActivityComponent.ActivityModule::class,
                MainActivityComponent.MainActivityModule::class,
                MainActivityComponent.FragmentBindingModule::class)
)
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {

    }

    @Module
    class ActivityModule {
        @Provides
        @Named(ACTIVITY_CONTEXT)
        fun provideContext(activity: AppCompatActivity): Context {
            return activity
        }
    }

    @Module
    class MainActivityModule {
        @Provides
        fun provideActivity(activity: MainActivity): AppCompatActivity {
            return activity
        }
    }

    @Module(subcomponents = arrayOf(GoalsFragmentComponent::class))
    interface FragmentBindingModule{
        @Binds
        @IntoMap
        @FragmentKey(GoalsFragment::class)
        fun providGoalFragmentComponentBuilder(builder: GoalsFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>

    }


}