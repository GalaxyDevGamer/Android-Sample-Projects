package galaxysoftware.androidTraining.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import galaxysoftware.androidTraining.R
import galaxysoftware.androidTraining.databinding.CounterLayoutBinding
import galaxysoftware.androidTraining.viewModel.CountSampleViewModel

class CountSampleFragment : BaseFragment() {

    private lateinit var viewModel: CountSampleViewModel

    private lateinit var binding: CounterLayoutBinding

    private val args: CountSampleFragmentArgs by navArgs()

    override fun menuId(): Int = args.menu

    override fun title(): String = args.title

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = CounterLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CountSampleViewModel::class.java)
        // TODO: Use the ViewModel
        binding.resetButton.setOnClickListener {
            viewModel.resetCount()
            showCount()
        }
        binding.countButton.setOnClickListener {
            viewModel.addCount()
            showCount()
        }
    }

    private fun showCount() {
        (getString(R.string.count) + viewModel.count).also { binding.countView.text = it }
    }
}
