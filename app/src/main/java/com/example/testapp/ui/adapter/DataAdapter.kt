package com.example.testapp.ui.adapter

import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.data.model.UnsplashPhoto
import com.example.testapp.databinding.ItemDataBinding

class DataAdapter(private var photoList: List<UnsplashPhoto>) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    class DataViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val photo = photoList[position]
        holder.binding.textTitle.text = photo.description ?: "No description"
        Glide.with(holder.itemView.context)
            .load(photo.urls.small)
            .into(holder.binding.imageView)
    }

    fun updateData (newPhotos: List<UnsplashPhoto>) {
        photoList = newPhotos
        notifyDataSetChanged()
    }


}