package com.example.demorestaurant

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demorestaurant.model.TableModel
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import de.hdodenhof.circleimageview.CircleImageView

class TableAdapter(options: FirebaseRecyclerOptions<TableModel>):
    FirebaseRecyclerAdapter<TableModel, TableAdapter.ViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.thongtindatban, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: TableModel) {
        holder.bind(model)

    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iurl = itemView.findViewById<CircleImageView>(R.id.img1)
        private val ten = itemView.findViewById<TextView>(R.id.name_table_txt)
        private val nguoidat = itemView.findViewById<TextView>(R.id.name_dat_txt)
        private val trangthai = itemView.findViewById<TextView>(R.id.trang_thai_txt)

        fun bind(item: TableModel) {
            Glide.with(iurl.context)
                .load(item.iurl)
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(iurl)
            ten.text = item.ten
            nguoidat.text = item.mail
            trangthai.text = item.trangthai
            iurl.setOnClickListener {
                val intent = Intent(it.context, DescActivity::class.java)

                intent.putExtra("ten", item.ten)
                intent.putExtra("iurl", item.iurl)
                intent.putExtra("nguoidat", item.mail)
                intent.putExtra("songuoi", item.songuoi)
                intent.putExtra("ngaydat", item.ngaydat)
                intent.putExtra("trangthai", item.trangthai)

                it.context.startActivity(intent)
            }
        }
    }

}