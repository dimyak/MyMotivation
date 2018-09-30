package com.example.keshl.mymotivation.presentation.goal

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import com.example.keshl.mymotivation.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.app_bar_main.view.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.act
import javax.inject.Inject

class GoalsFragment : Fragment(), GoalsContract.View {

    @Inject
    lateinit var mPresenter: GoalsContract.Presenter



    companion object {
        fun newInstance(): GoalsFragment {
            val args = Bundle()
            val fragment = GoalsFragment()
            fragment.setArguments(args)
            return fragment
        }
    }


    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_goals, container, false)
        mPresenter.onCreate(this)
        setHasOptionsMenu(true)
        return view
    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val result:Boolean = when{
            R.id.nav_new == item?.itemId-> itemNew()
            R.id.nav_important == item?.itemId ->itemImportant()
            else -> false
        }
        return result
    }

    private fun itemNew():Boolean{
        Log.d("MENU","NAV_NEW")
        return true
    }
    private fun itemImportant():Boolean{
        Log.d("MENU","NAV_IMPORTANT")
        return true
    }
}
