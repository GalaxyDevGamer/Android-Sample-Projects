package galaxysoftware.androidTraining.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import galaxysoftware.androidTraining.R
import galaxysoftware.androidTraining.databinding.ImageviewLayoutBinding
import galaxysoftware.androidTraining.viewModel.ImageViewSampleViewModel

class ImageViewSampleFragment : BaseFragment() {

    private lateinit var viewModel: ImageViewSampleViewModel

    private lateinit var binding: ImageviewLayoutBinding

    private val args: ImageViewSampleFragmentArgs by navArgs()

    override fun menuId(): Int = args.menu

    override fun title(): String = args.title

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = ImageviewLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ImageViewSampleViewModel::class.java)
        // TODO: Use the ViewModel
        binding.image.setImageResource(R.drawable.my_wife)
        binding.doSomething.setImageResource(R.mipmap.baseline_add_black_48)
        binding.doSomething.setOnClickListener { viewModel.doSomething() }
    }
}
