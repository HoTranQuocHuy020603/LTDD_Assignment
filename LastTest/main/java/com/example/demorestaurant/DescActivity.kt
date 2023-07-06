package com.example.demorestaurant

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.example.demorestaurant.logandreg.Login
import com.example.demorestaurant.pagesframe.ThongTinDat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.util.*

class DescActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.desclayout)


        val ten_desc = findViewById<TextView>(R.id.item_title)
        val iurl_desc = findViewById<ImageView>(R.id.iurl_desc)
        val nguoidat = findViewById<TextView>(R.id.nguoidat_desc)
        val songuoi_desc = findViewById<TextView>(R.id.songuoi_desc)
        val ngaydat_desc = findViewById<TextView>(R.id.ngaydat_desc)
        val trangthai_desc = findViewById<TextView>(R.id.trangthai_desc)

        val intent = intent

        val iurl_tbl = intent.getStringExtra("iurl")
        val ten_tbl = intent.getStringExtra("ten")
        val nguoidat_tbl = intent.getStringExtra("nguoidat")
        val songuoi_tbl = intent.getStringExtra("songuoi")
        val ngaydat_btl = intent.getStringExtra("ngaydat")
        val trangthai_tbl = intent.getStringExtra("trangthai")

        if(iurl_tbl != null){
            Glide.with(iurl_desc.context).load(iurl_tbl).into(iurl_desc)
        }

        ten_desc.text = ten_tbl
        nguoidat.text = nguoidat_tbl
        songuoi_desc.text = songuoi_tbl
        ngaydat_desc.text = ngaydat_btl
        trangthai_desc.text = trangthai_tbl

        findViewById<Button>(R.id.back_to_btn).setOnClickListener{
            val intent = Intent(this@DescActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}