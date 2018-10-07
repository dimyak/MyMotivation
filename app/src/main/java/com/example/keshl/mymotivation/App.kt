package com.example.keshl.mymotivation

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Inject

class App : Application(), HasActivityInjector{

    @Inject
    lateinit var mActivityDispatchingInjector: DispatchingAndroidInjector<Activity>

    companion object {
        fun get(context:Context) : App{
            return context.applicationContext as App
        }
    }

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val rlConfiguration = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name("DATABASE_NAME")
                .build()
        Realm.setDefaultConfiguration(rlConfiguration)

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }


    override fun activityInjector(): AndroidInjector<Activity> {
        return mActivityDispatchingInjector
    }


}