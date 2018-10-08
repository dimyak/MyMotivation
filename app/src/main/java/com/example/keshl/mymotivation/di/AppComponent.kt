package com.example.keshl.mymotivation.di

import android.app.Application
import com.example.keshl.mymotivation.App
import com.example.keshl.mymotivation.di.activity.ActivityBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [(ApplicationModule::class),
    (AndroidInjectionModule::class),
    (ActivityBuilderModule::class)])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)

}