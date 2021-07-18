package galaxysoftware.androidTraining.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import galaxysoftware.androidTraining.MainActivity

/**
 * Base class of [Fragment].
 */
abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().popBackStack()
        }
        initialize()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        activity?.menuInflater?.inflate(menuId(), menu)
        (activity as MainActivity).supportActionBar?.apply {
            title = title()
        }
        extraMenuSetup(menu)
    }

    open fun initialize() {}

    abstract fun menuId(): Int

    abstract fun title(): String

    open fun extraMenuSetup(menu: Menu) {}
}