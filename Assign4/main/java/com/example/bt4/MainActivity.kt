package com.example.bt4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var  imageRecycler:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageArray = arrayListOf<ImageInfo>()
        imageArray.add(ImageInfo("Android Studio", "image1", R.drawable.image1))
        imageArray.add(ImageInfo("Android Auto", "image2", R.drawable.image2))
        imageArray.add(ImageInfo("Android StudioAPP", "image3", R.drawable.image3))
        imageArray.add(ImageInfo("HTML", "image4", R.drawable.image4))
        imageArray.add(ImageInfo("CSS", "image5", R.drawable.image5))
        imageRecycler = findViewById(R.id.imageview)
        val imageAdapter = ImageAdapter(imageArray)
        imageRecycler.adapter= ImageAdapter(imageArray)
        imageRecycler.layoutManager= GridLayoutManager(this,2)

    }
}