package galaxysoftware.androidsamples.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import galaxysoftware.androidsamples.R
import galaxysoftware.androidsamples.callback.ItemClickListener
import galaxysoftware.androidsamples.type.FragmentType
import kotlinx.android.synthetic.main.recyclerview_item.view.*

/**
 * [RecyclerView.Adapter] that can display a [FragmentType] and makes a call to the
 * specified [ItemClickListener].
 * TODO: Replace the implementation with code for your data type.
 */
class RecyclerViewSampleAdapter(private val samples: ArrayList<FragmentType>, private val listener: ItemClickListener) : RecyclerView.Adapter<RecyclerViewSampleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = samples[position]
        holder.sampleView.text = item.title
        holder.itemView.setOnClickListener { listener.onItemSelected(item) }
    }

    override fun getItemCount() = samples.size

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val sampleView: TextView = mView.sample_name
    }
}
