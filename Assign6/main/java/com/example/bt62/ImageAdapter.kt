package com.example.bt62

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter (private val imageList: ArrayList<ImageInfo>):
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    var onItemClick : ((ImageInfo) -> Unit)? = null
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

        val cont = holder.desclayout.context
        holder.desclayout.setOnClickListener{
            val intent = Intent(it.context, DescActivity::class.java)

            intent.putExtra("article_title",image.article_title)
            intent.putExtra("article_image",image.article_image)
            intent.putExtra("article_description",image.article_description)

            it.context.startActivity(intent)

            Toast.makeText(cont, "the item ${image.article_image} is clicked", Toast.LENGTH_SHORT).show()
        }

        holder.desclayout.setOnLongClickListener(View.OnLongClickListener {
            Toast.makeText(cont, "the item ${image.article_image} is long clicked", Toast.LENGTH_SHORT).show()
            return@OnLongClickListener true
        })
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView = itemView.findViewById<ImageView>(R.id.image2)
        val imageNameTV = itemView.findViewById<TextView>(R.id.item_desc)

        val desclayout = itemView.findViewById<ConstraintLayout>(R.id.image_recycle_view)
    }

}
