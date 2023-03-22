package com.example.testingurl2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.testingurl2.R

class MainActivity : AppCompatActivity() {
    var imageList = arrayListOf<ImageInfo>()
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.imageview_R)

        val reqQuery = Volley.newRequestQueue(this)
        val request =  JsonObjectRequest(Request.Method.GET,
            "https://nopbai.live/data/data.json", null,{ res ->
                Log.d("Example", res.getString("name"))
                val jsonArray = res.getJSONArray("images")
                for(i in 0 until jsonArray.length()){
                    val jsonObj = jsonArray.getJSONObject(i)
                    Log.d("Example", jsonArray.toString())
                    val image = ImageInfo (
                        jsonObj.getString("name"),
                        jsonObj.getString("description")
                    )
                    imageList.add(image)
                }
                recyclerView.adapter = ImageAdapter(imageList)
                recyclerView.layoutManager = GridLayoutManager(this,2)


//            imageAdapter.onItemClick = {
//                val intent = Intent(this, DescActivity::class.java)
//                intent.putExtra("article_image",it)
//                startActivity(intent)
//            }
            }, {err ->
                Log.d("Example", err.message.toString())
            })
        reqQuery.add(request)



//    val imageView = findViewById<ImageView>(R.id.imageView)
//        findViewById<Button>(R.id.load_image).setOnClickListener{
//            Picasso.get().load("https://images.rawpixel.com/image_png_800/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvcm00MjgtZWxlbWVudC0yNy5wbmc.png?s=VhrzbK51wpP7Bs9ihv4MlHXpOdGB02yWN0Y1a07F_Es")
//                .placeholder(R.drawable.image1)
//                .error(R.drawable.image1)
//                .into(imageView);
//        }
    }
}