package com.example.testingurl2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

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
        Picasso.get().load(image.name).into(holder.imageView)
        holder.imageNameTV.text = image.description

        val cont = holder.desclayout.context
        holder.desclayout.setOnClickListener{
            val intent = Intent(it.context, DescActivity::class.java)

            intent.putExtra("name",image.name)
            intent.putExtra("description",image.description)

            it.context.startActivity(intent)

            Toast.makeText(cont, "the item ${image.name} is clicked", Toast.LENGTH_SHORT).show()
        }

        holder.desclayout.setOnLongClickListener(View.OnLongClickListener {
            Toast.makeText(cont, "the item ${image.name} is long clicked", Toast.LENGTH_SHORT).show()
            return@OnLongClickListener true
        })
        holder.delete.setOnClickListener(View.OnClickListener {
            imageList.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(cont, "the item ${image.name} was deleted", Toast.LENGTH_SHORT).show()
            return@OnClickListener
        })
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView = itemView.findViewById<ImageView>(R.id.image2)
        val imageNameTV = itemView.findViewById<TextView>(R.id.item_desc)

        val desclayout = itemView.findViewById<ConstraintLayout>(R.id.image_recycle_view)
        val delete = itemView.findViewById<Button>(R.id.del)
    }

}
