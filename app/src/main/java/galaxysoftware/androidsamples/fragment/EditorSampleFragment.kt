package galaxysoftware.androidsamples.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import galaxysoftware.androidsamples.R
import galaxysoftware.androidsamples.viewModel.EditorSampleViewModel
import kotlinx.android.synthetic.main.editor_layout.*

class EditorSampleFragment : Fragment() {

    companion object {
        fun newInstance() = EditorSampleFragment()
    }

    private lateinit var viewModel: EditorSampleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.editor_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProviders.of(this).get(EditorSampleViewModel::class.java)
        // TODO: Use the ViewModel
        button.setOnClickListener { result.text = editBox.text }
    }
}
