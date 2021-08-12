package com.android.tvmazeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.tvmazeapplication.adapter.RecyclerAdapter
import com.android.tvmazeapplication.model.ShowStructureItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var showsList = mutableListOf<ShowStructureItem>()
    private val viewModel: MainActivityViewModel by viewModel()
    private val myAdapter: RecyclerAdapter by lazy { RecyclerAdapter(showsList, this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        setup()
    }

    private fun setup(){
        viewModel.showListLiveData.observe(this){
            showsList.addAll(it)
            viewModel.saveShowsFromDb(showsList)

            lifecycleScope.launch {
                withContext(Dispatchers.Main){
                    myAdapter.setItem(showsList)
                }
            }
        }
        viewModel.loadingShows(0)
    }

    private fun setupRecycler(){
        val gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        rv_recyclerView.layoutManager = gridLayoutManager
        rv_recyclerView.setHasFixedSize(true)
        rv_recyclerView.adapter= myAdapter

    }

}