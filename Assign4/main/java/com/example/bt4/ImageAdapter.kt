package com.example.bt4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (val imageList: ArrayList<ImageInfo>):
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewItem = inflater.inflate(R.layout.imageitem, parent, false)
        return ViewHolder(viewItem)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageNameTV.text = imageList[position].name
        holder.imageCTR.text=imageList[position].category.toString()
        holder.imageView.setImageResource(imageList[position].image)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.image1)
        val imageNameTV = itemView.findViewById<TextView>(R.id.item1name)
        val imageCTR = itemView.findViewById<TextView>(R.id.item1CTR)
    }

}
