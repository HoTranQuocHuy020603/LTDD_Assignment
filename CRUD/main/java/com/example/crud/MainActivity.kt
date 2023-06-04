package com.example.crud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FirebaseDatabase.getInstance().reference.child("teachers")
        val options = FirebaseRecyclerOptions.Builder<MainModel>()
            .setQuery(database, MainModel::class.java)
            .setLifecycleOwner(this)
            .build()

        val adapter = MainAdapter(options)
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        val database = FirebaseDatabase.getInstance().reference.child("teachers")
        val options = FirebaseRecyclerOptions.Builder<MainModel>()
            .setQuery(database, MainModel::class.java)
            .setLifecycleOwner(this)
            .build()
        val adapter = MainAdapter(options)
        adapter.startListening()
    }
    override fun onStop() {
        super.onStop()
        val database = FirebaseDatabase.getInstance().reference.child("teachers")
        val options = FirebaseRecyclerOptions.Builder<MainModel>()
            .setQuery(database, MainModel::class.java)
            .setLifecycleOwner(this)
            .build()
        val adapter = MainAdapter(options)
        adapter.stopListening()
    }

}