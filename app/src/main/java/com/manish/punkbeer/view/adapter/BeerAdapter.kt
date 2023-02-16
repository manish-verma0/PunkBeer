package com.manish.punkbeer.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.manish.punkbeer.core.utils.BeerClickCallback
import com.manish.punkbeer.data.model.Beer
import com.manish.punkbeer.databinding.BeerItemBinding


class BeerAdapter(private val callback: BeerClickCallback) :
    ListAdapter<Beer, BeerAdapter.BeerViewHolder>(BeerComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val binding =
            BeerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BeerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem,callback)
        }
    }

    class BeerViewHolder(private val binding: BeerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(beer: Beer, callback: BeerClickCallback) {
            binding.apply {
                Glide.with(itemView.context).load(beer.imageUrl).into(beerImage)
                beerName.text = beer.name
                beerDesc.text = beer.description
                root.setOnClickListener {
                    callback.beerClick(beer)
                }
            }
        }
    }

    class BeerComparator : DiffUtil.ItemCallback<Beer>() {
        override fun areItemsTheSame(oldItem: Beer, newItem: Beer) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Beer, newItem: Beer) =
            oldItem == newItem
    }
}
