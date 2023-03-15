package com.example.bt62

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    var imageList = arrayListOf<ImageInfo>()
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.imageview_R)

        val reqQuery = Volley.newRequestQueue(this)
        val request =  JsonObjectRequest(Request.Method.GET,
            "https://fontkeyboard.org/wsv/?json_name=articles", null,{ res ->
                Log.d("Example", res.getString("articles"))
                val jsonArray = res.getJSONArray("articles")
                for(i in 0 until jsonArray.length()){
                    val jsonObj = jsonArray.getJSONObject(i)
                    Log.d("Example", jsonArray.toString())
                    val image = ImageInfo (
                        jsonObj.getInt("article_id"),
                        jsonObj.getString("article_title"),
                        jsonObj.getString("article_image"),
                        jsonObj.getString("article_description")
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