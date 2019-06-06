package galaxysoftware.androidsamples.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import galaxysoftware.androidsamples.R
import galaxysoftware.androidsamples.viewModel.BottomNavigationViewModel
import kotlinx.android.synthetic.main.bottom_navigation_layout.*

class BottomNavigationFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = BottomNavigationFragment()
    }

    private lateinit var viewModel: BottomNavigationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_navigation_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProviders.of(this).get(BottomNavigationViewModel::class.java)
        // TODO: Use the ViewModel
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.homeTab -> {
                    viewModel.homeTabClick()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.historyTab -> {
                    viewModel.historyTabClick()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.favouriteTab -> {
                    viewModel.favouriteTabClick()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

}
