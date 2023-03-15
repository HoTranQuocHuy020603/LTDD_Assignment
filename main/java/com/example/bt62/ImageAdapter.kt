package com.example.bt62

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter (private val imageList: ArrayList<ImageInfo>):
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    //    var onItemClick : ((ImageInfo) -> Unit)? = null
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val viewItem = LayoutInflater.from(context).inflate(R.layout.imageitem, parent, false)
        return ViewHolder(viewItem)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = imageList[position]
        Glide.with(context).load(image.article_image).into(holder.imageView)
        holder.imageNameTV.text = image.article_title

//        holder.itemView.setOnClickListener{
//            onItemClick?.invoke(image)
//        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.image2)
        val imageNameTV = itemView.findViewById<TextView>(R.id.item_desc)

    }

}
