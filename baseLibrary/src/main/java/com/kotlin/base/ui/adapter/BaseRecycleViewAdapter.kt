package com.kotlin.base.ui.adapter

import android.content.Context
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecycleViewAdapter<T, VH: RecyclerView.ViewHolder>(var mContext: Context): RecyclerView.Adapter<VH>() {
    var mItemClickListener: OnItemClickListener<T>? = null

    var dataList: MutableList<T> = mutableListOf()

    fun setData(sources: MutableList<T>) {
        dataList = sources
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            mItemClickListener?.let {
                it.onItemClick(dataList[position], position)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        this.mItemClickListener = listener
    }
}
