package galaxysoftware.androidsamples.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import galaxysoftware.androidsamples.R
import galaxysoftware.androidsamples.viewModel.ImageViewSampleViewModel
import kotlinx.android.synthetic.main.imageview_layout.*

class ImageViewSampleFragment : Fragment() {

    companion object {
        fun newInstance() = ImageViewSampleFragment()
    }

    private lateinit var viewModel: ImageViewSampleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.imageview_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProviders.of(this).get(ImageViewSampleViewModel::class.java)
        // TODO: Use the ViewModel
        image.setImageResource(R.drawable.my_wife)
        do_something.setImageResource(R.mipmap.baseline_add_black_48)
        do_something.setOnClickListener { viewModel.doSomething() }
    }

}
