package com.example.keshl.mymotivation.presentation.goal

import com.example.keshl.mymotivation.di.FragmentScope
import com.example.keshl.mymotivation.presentation.MainRouter
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScope
@Subcomponent(modules = arrayOf(GoalsFragmentComponent.GoalsFragmentModule::class))
interface GoalsFragmentComponent : AndroidInjector<GoalsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<GoalsFragment>() {}

    @Module
    class GoalsFragmentModule {

        @Provides
        internal fun provideFavoritesView(fragment: GoalsFragment): GoalsContract.View {
            return fragment
        }

        @Provides
        internal fun provideFavoritesPresenter(presenter: GoalsPresenter): GoalsContract.Presenter {
            return presenter
        }

        @Provides
        internal fun provideRouter(router: MainRouter): GoalsContract.Router {
            return router
        }

        @Provides
        internal fun provideEvenDelegate(delegate: GoalsPresenter): GoalsContract.EvenDelegate {
            return delegate
        }

    }
}
