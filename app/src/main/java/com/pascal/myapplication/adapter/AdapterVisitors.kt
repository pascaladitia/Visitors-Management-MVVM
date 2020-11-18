package com.pascal.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pascal.myapplication.R
import com.pascal.myapplication.model.visitors.DataItem
import kotlinx.android.synthetic.main.item_visitors.view.*

class AdapterVisitors(
    private val data: List<DataItem?>?,
    private val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterVisitors.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterVisitors.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_visitors, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.bind(item)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: DataItem?) {
            view.item_name.text = item?.name
            view.item_status.text = item?.profession

            view.setOnClickListener{
                itemClick.detail(item)
            }

            view.item_delete.setOnClickListener {
                itemClick.delete(item)
            }

            view.item_update.setOnClickListener {
                itemClick.update(item)
            }
        }
    }

    interface OnClickListener {
        fun detail(item: DataItem?)
        fun update(item: DataItem?)
        fun delete(item: DataItem?)
    }
}