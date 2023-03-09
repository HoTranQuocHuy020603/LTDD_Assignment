package com.example.bt5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.ResultReceiver
import android.provider.ContactsContract.Data
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
     var uri: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
        val username = intent.getStringExtra("user")
        findViewById<ImageView>(R.id.home_image_iv)
        findViewById<TextView>(R.id.home_welcome_tv).text = "Welcome, $username"
        findViewById<Button>(R.id.home_gotourl_btn).setOnClickListener{
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = Uri.parse("https://www.google.com")
            startActivity(urlIntent)
        }
        findViewById<Button>(R.id.home_back_btn).setOnClickListener{
//            val intent = Intent(this@HomeActivity, MainActivity::class.java)
//            intent.putExtra("image", uri)
//            startActivity(intent)
            val intent = Intent()
            intent.putExtra("image", uri)
            setResult(RESULT_OK, intent)
            finish()
        }
        findViewById<Button>(R.id.home_choselogo_btn).setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100){
            if(data != null){
                findViewById<ImageView>(R.id.home_image_iv).setImageURI(data.data)
                uri = data.data.toString()
            }
        }
    }
}