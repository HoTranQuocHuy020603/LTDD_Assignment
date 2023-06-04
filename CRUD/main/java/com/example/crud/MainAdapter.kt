package com.example.crud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import de.hdodenhof.circleimageview.CircleImageView

class MainAdapter(options: FirebaseRecyclerOptions<MainModel>):
    FirebaseRecyclerAdapter<MainModel, MainAdapter.ViewHolder>(options) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: MainModel) {
        holder.bind(model)
//        holder.name.text = model.name
//        holder.course.text = model.course
//        holder.email.text = model.email
//
//        Glide.with(holder.img.context)
//            .load(model.turl)
//            .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
//            .circleCrop()
//            .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
//            .into(holder.img)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val img = itemView.findViewById<CircleImageView>(R.id.img1)
        private val name = itemView.findViewById<TextView>(R.id.name_txt)
        private val course = itemView.findViewById<TextView>(R.id.course_txt)
        private val email = itemView.findViewById<TextView>(R.id.email_txt)

        fun bind(item: MainModel) {
            Glide.with(img.context)
            .load(item.turl)
            .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
            .circleCrop()
            .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
            .into(img)
            name.text = item.name
            course.text = item.course
            email.text = item.email
        }
    }
}
