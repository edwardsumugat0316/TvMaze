package com.android.tvmazeapplication

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.tvmazeapplication.adapter.RecyclerAdapter
import com.android.tvmazeapplication.base.BaseActivity
import com.android.tvmazeapplication.model.ShowEntity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener{
    private var showsList = mutableListOf<ShowEntity>()
    private val viewModel: MainActivityViewModel by viewModel()
    private val myAdapter: RecyclerAdapter by lazy { RecyclerAdapter(showsList, this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        setup()
        setupNavigationDrawer()
    }

    private fun setup(){
        viewModel.showListLiveData.observe(this){
            showsList.addAll(it)

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

    private fun setupNavigationDrawer(){
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white))
        toggle.syncState()

        nav_menu.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)

        when(item.itemId){
            R.id.exit -> {
                finish()
            }
        }
        return true
    }

}