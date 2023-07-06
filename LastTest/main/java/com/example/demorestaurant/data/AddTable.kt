package com.example.demorestaurant.data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.demorestaurant.R
import com.example.demorestaurant.model.TableModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.collections.HashMap

class AddTable : AppCompatActivity() {

    private lateinit var ten:EditText
    private lateinit var mail:EditText
    private lateinit var songuoi:EditText
    private lateinit var ngaydat:EditText
    private lateinit var iurl:EditText
    private lateinit var trangthai:EditText
    private lateinit var btn_add:Button
    private lateinit var btn_back:Button

    private lateinit var database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_table)

        ten = findViewById(R.id.txt_ten)
        mail = findViewById(R.id.txt_mail)
        songuoi = findViewById(R.id.txt_songuoi)
        ngaydat = findViewById(R.id.txt_ngaydat)
        iurl = findViewById(R.id.txt_iurl)
        trangthai = findViewById(R.id.txt_trangthai)

        btn_add = findViewById(R.id.add_btn)
        btn_back = findViewById(R.id.back_to_btn)

        btn_add.setOnClickListener{
            insertData()
            clearAll()
        }

        btn_back.setOnClickListener{
            finish()
        }

    }

    private fun insertData() {
        val map: MutableMap<String, Any> = HashMap()
        map["ten"] = ten.text.toString()
        map["mail"] = mail.text.toString()
        map["songuoi"] = songuoi.text.toString()
        map["ngaydat"] = ngaydat.text.toString()
        map["iurl"] = iurl.text.toString()
        map["trangthai"] = trangthai.text.toString()
        FirebaseDatabase.getInstance().reference.child("bandadat")
            .push()
            .setValue(map)
            .addOnSuccessListener {
                Toast.makeText(this@AddTable, "Successfully", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this@AddTable, "Failed", Toast.LENGTH_SHORT).show()
            }
    }

    private fun clearAll(){
        ten.setText("")
        mail.setText("")
        songuoi.setText("")
        ngaydat.setText("")
        iurl.setText("")
        trangthai.setText("")
    }

}