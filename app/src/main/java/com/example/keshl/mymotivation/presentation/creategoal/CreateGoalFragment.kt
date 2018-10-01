package com.example.keshl.mymotivation.presentation.creategoal

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.util.Log
import android.view.*
import com.example.keshl.mymotivation.R
import com.example.keshl.mymotivation.presentation.MainActivity
import com.example.keshl.mymotivation.presentation.common.BaseFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class CreateGoalFragment : BaseFragment(), CreateGoalContract.View {

    private lateinit var actionBar: ActionBar
    @Inject
    lateinit var mPresenter: CreateGoalContract.Presenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_create_goal, container, false)
        mPresenter.onCreateView(this)
        return view
    }


    override fun onDestroy() {
        actionBar.setHomeButtonEnabled(false)
        mPresenter.onDestroy()
        super.onDestroy()
    }

    @SuppressLint("RestrictedApi")
    override fun setupFAB() {
        var fab: FloatingActionButton = activity!!.fab
        fab.visibility = View.VISIBLE
        fab.setImageResource(R.drawable.ic_save_white)
        fab.setOnClickListener {
            Log.d("TEST", "FAB NEW GOALS FRAGMENT")

        }
    }

    override fun setupToolbar() {
        setHasOptionsMenu(true)
        actionBar = (activity as MainActivity).supportActionBar!!
        actionBar.setTitle(R.string.create_new_goal)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeButtonEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == android.R.id.home) {
            activity!!.onBackPressed()
        }
        return true
    }

    companion object {
        fun newInstance(): CreateGoalFragment {
            val args = Bundle()
            val fragment = CreateGoalFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
