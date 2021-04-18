package com.dongmin.certiapp.ui.festival.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dongmin.certiapp.R
import com.dongmin.certiapp.data.festival.FestivalItem
import com.dongmin.certiapp.databinding.ItemFestivalBinding
import com.dongmin.certiapp.ui.festival.FestivalModel



class FestivalAdapter(diffCallback: DiffUtil.ItemCallback<FestivalItem>) : PagingDataAdapter<FestivalItem, FestivalAdapter.FestivalViewHolder>(
    diffCallback
) {
    val LODING_ITEM = 0
    val FESTIVAL_ITEM = 1
    override fun onBindViewHolder(holder: FestivalViewHolder, position: Int) {
        var festivalInfo = getItem(position)
        if(festivalInfo != null){
            holder.binding.festivalTitle.text = festivalInfo.title
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FestivalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_festival,parent, false)
        return FestivalViewHolder(view)
    }
/*
    override fun getItemViewType(position: Int): Int {
        var type = if(position == itemCount) FESTIVAL_ITEM else LODING_ITEM
        return type
    }


 */


    class FestivalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemFestivalBinding.bind(itemView)
    }


}