package com.example.keshl.mymotivation.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.example.keshl.mymotivation.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var mAndroidInjector: DispatchingAndroidInjector<Fragment>


    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mAndroidInjector
    }

    @Inject
    lateinit var mMainRouter: MainRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMainRouter.navigateToGoalsFragment()
        setSupportActionBar(toolbar)
        initView()

    }

    private fun initView() {
        initDrawer()
        initBottomMenu()
    }

    private fun initDrawer() {
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
                this,
                drawer_layout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {}

        // Configure the drawer layout to add listener and show icon on toolbar
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    private fun initBottomMenu() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            var result: Boolean
            when (it.itemId) {
                R.id.bnv_goals -> {
                    mMainRouter.navigateToGoalsFragment()
                    result = true
                }
                else-> result = false
            }
            result

        }
    }

    fun hideBottomNavigation() {
        val bottomTranslation = appBarBottom.translationY + appBarBottom.height
        appBarBottom.animate().translationY(bottomTranslation)
    }

    fun showBottomNavigation() {
        val bottomTranslation = appBarBottom.translationY - appBarBottom.height
        appBarBottom.animate().translationY(bottomTranslation)
    }


}
