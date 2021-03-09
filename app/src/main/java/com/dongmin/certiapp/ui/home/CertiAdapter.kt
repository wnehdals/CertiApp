package com.dongmin.certiapp.ui.home

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dongmin.certiapp.R
import com.dongmin.certiapp.data.Item
import com.dongmin.certiapp.databinding.ItemCertiBinding
import java.util.*

class CertiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemCertiBinding.bind(itemView)
}

class CertiAdapter : RecyclerView.Adapter<CertiViewHolder>() {
    private var items: List<Item> = ArrayList<Item>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CertiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_certi, parent, false)
        return CertiViewHolder(view)
    }


    override fun onBindViewHolder(holder: CertiViewHolder, position: Int) {
        holder.binding.item = items[position]
    }
    fun updateImtes(item: List<Item>) {
        items = item
        if (!item.isEmpty()) {
            Log.e("sdf", "exist")
        } else {
            Log.e("sdf", "empty")
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }


}

@BindingAdapter("jmfldnm")
fun setCertiName(textView: TextView, item: Item){
    textView.text = item.jmfldnm
}
@BindingAdapter("qualgbnm")
fun setType(textView: TextView, item: Item){
    textView.text = item.qualgbnm
}

@BindingAdapter("seriesnm")
fun setSerial(textView: TextView, item: Item){
    textView.text = item.seriesnm
}
