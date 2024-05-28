package com.example.firstapp

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.databinding.ItemSecondBinding

class SecondAdapter(private val items: List<Pair<Uri, String>>) : RecyclerView.Adapter<SecondAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSecondBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ItemSecondBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pair<Uri, String>) {
            // Load image using Glide
            Glide.with(binding.root)
                .load(item.first)
                .into(binding.imageViewSecond)

            // Set text
            binding.textViewSecondName.text = item.second
        }
    }
}



