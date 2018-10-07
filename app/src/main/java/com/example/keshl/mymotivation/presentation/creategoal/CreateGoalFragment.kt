package com.example.keshl.mymotivation.presentation.creategoal

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.PopupMenu
import com.example.keshl.mymotivation.R
import com.example.keshl.mymotivation.presentation.MainActivity
import com.example.keshl.mymotivation.presentation.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_create_goal.*
import javax.inject.Inject


class CreateGoalFragment : BaseFragment(), CreateGoalContract.View {


    @Inject
    lateinit var mPresenter: CreateGoalContract.Presenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_create_goal, container, false)
        mPresenter.onCreateView(this)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {

        rl_typeGoal.setOnClickListener {
            var popup: PopupMenu? = null
            popup = PopupMenu(context, view, Gravity.BOTTOM)
            popup.setOnMenuItemClickListener {
                it.isChecked = !it.isChecked

                // Do other stuff

                // Keep the popup menu open
                it.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW)
                it.actionView = View(context)
                it.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
                    override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                        return false
                    }

                    override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                        return false
                    }
                })
                false
            }
            popup.inflate(R.menu.goal_type_menu)
            popup.show()
        }
    }


    override fun onDestroy() {
        mPresenter.onDestroy()
        super.onDestroy()
    }

    @SuppressLint("RestrictedApi")
    override fun setupFAB() {

        fabCreateGoal.setImageResource(R.drawable.ic_save_white)
        fabCreateGoal.setOnClickListener {
            Log.d("TEST", "FAB NEW GOALS FRAGMENT")
        }
    }

    override fun setupToolbar() {
        setHasOptionsMenu(true)

        var appCompatActivity = activity as MainActivity?

        appCompatActivity?.supportActionBar?.setTitle(R.string.create_new_goal)
        appCompatActivity?.enableViews(true)


        //appCompatActivity?.drawerToggle?.isDrawerIndicatorEnabled = false
        //appCompatActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //appCompatActivity?.supportActionBar?.setDisplayShowHomeEnabled(true)
        //appCompatActivity?.supportActionBar?.setHomeButtonEnabled(true)


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
