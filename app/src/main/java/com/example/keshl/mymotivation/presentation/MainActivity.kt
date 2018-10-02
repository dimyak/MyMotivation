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
import android.support.v4.widget.DrawerLayout


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var mAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var mMainRouter: MainRouter

    private lateinit var drawerToggle: ActionBarDrawerToggle
    private var mToolBarNavigationListenerIsRegistered = false


    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mAndroidInjector
    }


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
        drawerToggle = object : ActionBarDrawerToggle(
                this,
                drawer_layout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {}

        // Configure the drawer layout to add listener and show icon on toolbar

        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    fun enableViews(enable: Boolean) {

        // To keep states of ActionBar and ActionBarDrawerToggle synchronized,
        // when you enable on one, you disable on the other.
        // And as you may notice, the order for this operation is disable first, then enable - VERY VERY IMPORTANT.
        if (enable) {
            //You may not want to open the drawer on swipe from the left in this case
            drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            // Remove hamburger
            drawerToggle.isDrawerIndicatorEnabled = false

            // Show back button
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            // when DrawerToggle is disabled i.e. setDrawerIndicatorEnabled(false), navigation icon
            // clicks are disabled i.e. the UP button will not work.
            // We need to add a listener, as in below, so DrawerToggle will forward
            // click events to this listener.
            if (!mToolBarNavigationListenerIsRegistered) {
                drawerToggle.toolbarNavigationClickListener = View.OnClickListener {
                    // Doesn't have to be onBackPressed
                    onBackPressed()
                }

                mToolBarNavigationListenerIsRegistered = true
            }

        } else {
            //You must regain the power of swipe for the drawer.
            drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)

            // Remove back button
            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            // Show hamburger
            drawerToggle.isDrawerIndicatorEnabled = true
            // Remove the/any drawer toggle listener
            drawerToggle.toolbarNavigationClickListener = null
            mToolBarNavigationListenerIsRegistered = false
        }

        // So, one may think "Hmm why not simplify to:
        // .....
        // getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
        // mDrawer.setDrawerIndicatorEnabled(!enable);
        // ......
        // To re-iterate, the order in which you enable and disable views IS important #dontSimplify.
    }

    private fun initBottomMenu() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            var result: Boolean
            when (it.itemId) {
                R.id.bnv_goals -> {
                    mMainRouter.navigateToGoalsFragment()
                    result = true
                }
                R.id.bnv_tape -> {
                    mMainRouter.navigateToGoalsFragment()
                    result = true
                }
                R.id.bnv_favorites -> {
                    mMainRouter.navigateToGoalsFragment()
                    result = true
                }
                else -> result = false
            }
            result

        }
    }

    fun hideBottomNavigation() {
        appBarBottom.visibility = View.GONE
    }

    fun showBottomNavigation() {
        appBarBottom.visibility = View.VISIBLE
        appBarBottom.alpha = 0.0f
        appBarBottom.animate().alpha(1.0f).start()
    }


}
