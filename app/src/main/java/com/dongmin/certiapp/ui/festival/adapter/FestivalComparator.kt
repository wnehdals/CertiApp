package com.dongmin.certiapp.ui.festival.adapter

import androidx.paging.DifferCallback
import androidx.recyclerview.widget.DiffUtil
import com.dongmin.certiapp.data.festival.FestivalItem

class FestivalComparator: DiffUtil.ItemCallback<FestivalItem>() {
    override fun areItemsTheSame(oldItem: FestivalItem, newItem: FestivalItem): Boolean {
        return oldItem.contentid.equals(newItem.contentid)

    }

    override fun areContentsTheSame(oldItem: FestivalItem, newItem: FestivalItem): Boolean {
        return oldItem.contentid.equals(newItem.contentid)
    }
}