package galaxysoftware.androidTraining.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import galaxysoftware.androidTraining.databinding.EditorLayoutBinding
import galaxysoftware.androidTraining.viewModel.EditorSampleViewModel

class EditorSampleFragment : BaseFragment() {

    private lateinit var viewModel: EditorSampleViewModel

    private lateinit var binding: EditorLayoutBinding

    private val args: EditorSampleFragmentArgs by navArgs()

    override fun menuId(): Int = args.menu

    override fun title(): String = args.title

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = EditorLayoutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditorSampleViewModel::class.java)
        // TODO: Use the ViewModel
        binding.button.setOnClickListener { binding.result.text = binding.editBox.text }
    }
}
