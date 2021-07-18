package galaxysoftware.androidTraining.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import galaxysoftware.androidTraining.MainActivity
import galaxysoftware.androidTraining.R
import galaxysoftware.androidTraining.adapter.RecyclerViewSampleAdapter
import galaxysoftware.androidTraining.callback.ItemClickListener
import galaxysoftware.androidTraining.databinding.RecyclerviewLayoutBinding
import galaxysoftware.androidTraining.type.FragmentType

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ItemClickListener] interface.
 */
class RecyclerViewSampleFragment : Fragment(), ItemClickListener {

    private lateinit var sampleAdapter: RecyclerViewSampleAdapter
    private var samples = ArrayList<FragmentType>()
    private lateinit var binding: RecyclerviewLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        samples.add(FragmentType.COUNTER_SAMPLE)
        samples.add(FragmentType.EDITOR_SAMPLE)
        samples.add(FragmentType.IMAGE_VIEW_SAMPLE)
        samples.add(FragmentType.BOTTOM_NAVIGATION_SAMPLE)
        samples.add(FragmentType.WEB_VIEW_SAMPLE)
        sampleAdapter = RecyclerViewSampleAdapter(samples, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecyclerviewLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = sampleAdapter
        }
        binding.refreshList.setOnRefreshListener {
            //Refresh items

            sampleAdapter.notifyDataSetChanged()
            binding.refreshList.isRefreshing = false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        activity?.menuInflater?.inflate(R.menu.main, menu)
        (activity as MainActivity).supportActionBar?.apply {
            title = "RecyclerView Sample"
        }
    }

    override fun onItemSelected(index: Int) {
        findNavController().navigate(samples[index].directions)
    }
}