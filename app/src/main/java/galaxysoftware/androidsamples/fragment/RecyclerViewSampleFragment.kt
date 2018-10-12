package galaxysoftware.androidsamples.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import galaxysoftware.androidsamples.R
import galaxysoftware.androidsamples.adapter.RecyclerViewSampleAdapter
import galaxysoftware.androidsamples.application.App
import galaxysoftware.androidsamples.callback.ItemClickListener

import galaxysoftware.androidsamples.type.FragmentType
import kotlinx.android.synthetic.main.recyclerview_layout.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ItemClickListener] interface.
 */
class RecyclerViewSampleFragment : Fragment(), ItemClickListener {

    private lateinit var sampleAdapter: RecyclerViewSampleAdapter
    private var samples = ArrayList<FragmentType>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        samples.add(FragmentType.COUNTER_SAMPLE)
        samples.add(FragmentType.EDITOR_SAMPLE)
        samples.add(FragmentType.IMAGE_VIEW_SAMPLE)
        samples.add(FragmentType.BOTTOM_NAVIGATION_SAMPLE)
        samples.add(FragmentType.WEBVIEW_SAMPLE)
        sampleAdapter = RecyclerViewSampleAdapter(samples, this)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recyclerview_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = sampleAdapter
        }
    }

    override fun onItemSelected(fragmentType: FragmentType) {
        (activity?.application as App).mainActivity?.addFragment(fragmentType)
    }

    companion object {
        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance() = RecyclerViewSampleFragment()
    }
}
