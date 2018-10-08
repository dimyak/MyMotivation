package com.example.keshl.mymotivation.presentation.goal

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*
import com.example.keshl.mymotivation.R
import com.example.keshl.mymotivation.domain.GoalModel
import com.example.keshl.mymotivation.presentation.MainActivity
import com.example.keshl.mymotivation.presentation.common.BaseFragment
import com.example.keshl.mymotivation.presentation.goal.common.AdapterGoalsList
import kotlinx.android.synthetic.main.fragment_goals.*
import javax.inject.Inject

class GoalsFragment : BaseFragment(), GoalsContract.View {
    private lateinit var mAdapter: AdapterGoalsList

    @Inject
    lateinit var mPresenter: GoalsContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_goals, container, false)
        mPresenter.onCreateView(this)
        return view
    }
    override fun onDestroy() {
        mPresenter.onDestroy()
        super.onDestroy()
    }


    override fun initView() {
        setupRecycler()
    }



    fun setupRecycler() {
        mAdapter = AdapterGoalsList(mPresenter)
        goalsList.layoutManager = LinearLayoutManager(context)
        goalsList.adapter = mAdapter
    }

    override fun setGoalList(listGoal: List<GoalModel>) {
        mAdapter.setGoalList(listGoal)
    }

    @SuppressLint("RestrictedApi")
    override fun setupFAB() {
        fabGoal.setImageResource(R.drawable.ic_add_white)
        fabGoal.setOnClickListener {
            Log.d("TEST", "FAB GOALS FRAGMENT")
            mPresenter.createNewGoal()
        }
    }

    override fun setupToolbar() {
        setHasOptionsMenu(true)
        var appCompatActivity = activity as MainActivity?
        appCompatActivity?.supportActionBar?.setTitle(R.string.goals)
        appCompatActivity?.enableViews(false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.goal_fragment_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        Log.d("TEST", "MENU GOALS FRAGMENT")
        return true
    }

    companion object {
        fun newInstance(): GoalsFragment {
            val args = Bundle()
            val fragment = GoalsFragment()
            fragment.arguments = args
            return fragment
        }
    }


}
