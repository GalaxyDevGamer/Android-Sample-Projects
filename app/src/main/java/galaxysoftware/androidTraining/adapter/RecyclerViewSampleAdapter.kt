package galaxysoftware.androidTraining.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import galaxysoftware.androidTraining.callback.ItemClickListener
import galaxysoftware.androidTraining.databinding.RecyclerviewItemBinding
import galaxysoftware.androidTraining.type.FragmentType

/**
 * [RecyclerView.Adapter] that can display a [FragmentType] and makes a call to the
 * specified [ItemClickListener].
 * TODO: Replace the implementation with code for your data type.
 */
class RecyclerViewSampleAdapter(private val samples: ArrayList<FragmentType>, private val listener: ItemClickListener) : RecyclerView.Adapter<RecyclerViewSampleAdapter.ViewHolder>() {

    private lateinit var binding: RecyclerviewItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = samples[position]
        holder.sampleView.text = item.title
        holder.itemView.setOnClickListener { listener.onItemSelected(position) }
    }

    override fun getItemCount() = samples.size

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val sampleView: TextView = binding.sampleName
    }
}
