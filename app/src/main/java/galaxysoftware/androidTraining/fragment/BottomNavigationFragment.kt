package galaxysoftware.androidTraining.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import galaxysoftware.androidTraining.R
import galaxysoftware.androidTraining.databinding.BottomNavigationLayoutBinding
import galaxysoftware.androidTraining.viewModel.BottomNavigationViewModel

class BottomNavigationFragment : BaseFragment() {

    private lateinit var viewModel: BottomNavigationViewModel

    private lateinit var binding: BottomNavigationLayoutBinding

    private val args: BottomNavigationFragmentArgs by navArgs()

    override fun menuId(): Int = args.menu

    override fun title(): String = args.title

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomNavigationLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(BottomNavigationViewModel::class.java)
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeTab -> {
                    viewModel.homeTabClick()
                    return@setOnItemSelectedListener true
                }
                R.id.historyTab -> {
                    viewModel.historyTabClick()
                    return@setOnItemSelectedListener true
                }
                R.id.favouriteTab -> {
                    viewModel.favouriteTabClick()
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener false
                }
            }
        }
    }
}
