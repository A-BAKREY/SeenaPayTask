package com.example.seenapaytask.presention

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seenapaytask.R
import com.example.seenapaytask.adapter.RecyclerAdapter
import com.example.seenapaytask.presention.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
        initViewModle()

    }

    private fun initialize()
    {
        recycleID.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = RecyclerAdapter()
        recycleID.adapter = recyclerAdapter
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModle(){
          mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
          mainViewModel.getLiveDataObserve().observe(this
        ) { t ->
            if (t != null) {
                recyclerAdapter.setListDate(t)
                recyclerAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"error occurred",Toast.LENGTH_LONG).show()
            }
        }

        mainViewModel.makeApiCall()

    }
}