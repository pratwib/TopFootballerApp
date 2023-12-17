package com.pratwib.myrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pratwib.myrecyclerview.databinding.ItemRowFootballerBinding

class ListFootballerAdapter(private val listFootballers: ArrayList<Footballer>) :
    RecyclerView.Adapter<ListFootballerAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowFootballerBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, i: Int) {
        val context = holder.itemView.context
        val (name, description, photo, age, price, link, position) = listFootballers[i]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener {
            val passItem = Intent(context, DetailActivity::class.java)
            passItem.putExtra(DetailActivity.EXTRA_NAME, name)
            passItem.putExtra(DetailActivity.EXTRA_PHOTO, photo)
            passItem.putExtra(DetailActivity.EXTRA_AGE, age)
            passItem.putExtra(DetailActivity.EXTRA_PRICE, price)
            passItem.putExtra(DetailActivity.EXTRA_POSITION, position)
            passItem.putExtra(DetailActivity.EXTRA_DESCRIPTION, description)
            passItem.putExtra(DetailActivity.EXTRA_LINK, link)
            context.startActivity(passItem)
        }    }

    override fun getItemCount(): Int = listFootballers.size

    class ListViewHolder(var binding: ItemRowFootballerBinding) : RecyclerView.ViewHolder(binding.root)
}