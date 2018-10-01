package com.example.keshl.mymotivation.presentation.creategoal

import com.example.keshl.mymotivation.di.FragmentScope
import com.example.keshl.mymotivation.presentation.MainRouter
import com.example.keshl.mymotivation.presentation.goal.GoalsFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(modules = arrayOf(CreateGoalFragmentComponent.CreateGoalFragmentModule::class))
interface CreateGoalFragmentComponent : AndroidInjector<CreateGoalFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<CreateGoalFragment>()

    @Module
    class CreateGoalFragmentModule {

        @Provides
        internal fun provideCreateView(fragment: CreateGoalFragment): CreateGoalContract.View {
            return fragment
        }

        @Provides
        internal fun provideFavoritesPresenter(presenter: CreateGoalPresenter): CreateGoalContract.Presenter {
            return presenter
        }

        @Provides
        internal fun provideRouter(router: MainRouter): CreateGoalContract.Router {
            return router
        }


    }
}