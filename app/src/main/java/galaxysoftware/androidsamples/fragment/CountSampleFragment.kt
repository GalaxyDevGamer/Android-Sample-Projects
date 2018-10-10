package galaxysoftware.androidsamples.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import galaxysoftware.androidsamples.R
import galaxysoftware.androidsamples.viewModel.CountSampleViewModel
import kotlinx.android.synthetic.main.counter_layout.*

class CountSampleFragment : Fragment() {

    companion object {
        fun newInstance() = CountSampleFragment()
    }

    private lateinit var viewModel: CountSampleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.counter_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProviders.of(this).get(CountSampleViewModel::class.java)
        // TODO: Use the ViewModel
        reset_button.setOnClickListener {
            viewModel.resetCount()
            showCount()
        }
        count_button.setOnClickListener {
            viewModel.addCount()
            showCount()
        }
    }

    private fun showCount() {
        countView.text = getString(R.string.count) + viewModel.count
    }
}
