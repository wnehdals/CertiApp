package com.dongmin.certiapp.ui.festival.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dongmin.certiapp.R
import com.dongmin.certiapp.data.festival.FestivalItem
import com.dongmin.certiapp.databinding.ItemFestivalBinding


class FestivalAdapter : PagingDataAdapter<FestivalItem, FestivalAdapter.FestivalViewHolder>(FestivalComparator()){
    override fun onBindViewHolder(holder: FestivalViewHolder, position: Int) {
        val festivalItem = getItem(position)
        if(festivalItem != null){
            holder.bind(festivalItem)
        }
        //holder.binding.festivalTitle.text = getItem(position)?.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FestivalViewHolder {
        return FestivalViewHolder(
            ItemFestivalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    class FestivalViewHolder(private val binding: ItemFestivalBinding) : RecyclerView.ViewHolder(binding.root) {
        init {

        }
        fun bind(item: FestivalItem){
            binding.apply {
                festivalItem = item
                executePendingBindings()
            }
        }
    }
}

private class FestivalComparator : DiffUtil.ItemCallback<FestivalItem>() {
    override fun areItemsTheSame(oldItem: FestivalItem, newItem: FestivalItem): Boolean {
        return oldItem.contentid == newItem.contentid
    }

    override fun areContentsTheSame(oldItem: FestivalItem, newItem: FestivalItem): Boolean {
        return oldItem == newItem
    }
}