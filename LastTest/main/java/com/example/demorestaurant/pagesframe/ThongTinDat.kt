package com.example.demorestaurant.pagesframe

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demorestaurant.R
import com.example.demorestaurant.TableAdapter
import com.example.demorestaurant.model.TableModel
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ThongTinDat : Fragment(R.layout.fragment_thong_tin_dat) {
    lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth = FirebaseAuth.getInstance()
        val view = inflater.inflate(R.layout.fragment_thong_tin_dat,container,false)
        val database = FirebaseDatabase.getInstance().reference.child("bandadat")
        val options = FirebaseRecyclerOptions.Builder<TableModel>()
            .setQuery(database, TableModel::class.java)
            .setLifecycleOwner(this)
            .build()

        val adapter = TableAdapter(options)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view

    }
    override fun onStart() {
        super.onStart()
        val database = FirebaseDatabase.getInstance().reference.child("bandadat")
        val options = FirebaseRecyclerOptions.Builder<TableModel>()
            .setQuery(database, TableModel::class.java)
            .setLifecycleOwner(this)
            .build()
        val adapter = TableAdapter(options)
        adapter.startListening()
    }
    override fun onStop() {
        super.onStop()
        val database = FirebaseDatabase.getInstance().reference.child("bandadat")
        val options = FirebaseRecyclerOptions.Builder<TableModel>()
            .setQuery(database, TableModel::class.java)
            .setLifecycleOwner(this)
            .build()
        val adapter = TableAdapter(options)
        adapter.stopListening()
    }


}

