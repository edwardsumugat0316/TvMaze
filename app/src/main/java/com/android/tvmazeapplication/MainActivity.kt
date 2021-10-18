package com.android.tvmazeapplication
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    private var isLoading = false
    private var page = 0
    private var isSearchActive = false
    private val myAdapter: RecyclerAdapter by lazy { RecyclerAdapter(showsList, this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        setup()
        setupNavigationDrawer()
        search()
    }

    private fun setup(){
        viewModel.showListLiveData.observe(this){
            showsList.addAll(it)
            isLoading = false
            lifecycleScope.launch {
                withContext(Dispatchers.Main){
                    myAdapter.setItem(showsList)
                }
            }
        }
        viewModel.searchLiveData.observe(this){
            myAdapter.setItem(it)
        }
        viewModel.loadingShows(page)
    }



    private fun setupRecycler() {
        val gridLayoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        rv_recyclerView.layoutManager = gridLayoutManager
        rv_recyclerView.setHasFixedSize(true)
        rv_recyclerView.adapter = myAdapter

        rv_recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(!recyclerView.canScrollVertically(1)){
                    val visibleItemCount = gridLayoutManager.childCount
                    val pastVisibleItem = gridLayoutManager.findFirstCompletelyVisibleItemPosition()
                    val total = myAdapter.itemCount

                    if (!isLoading && !isSearchActive){
                        if ((visibleItemCount + pastVisibleItem) >= total){
                            page++
                            viewModel.loadingShows(page)
                            isLoading = true
                        }
                        Toast.makeText(this@MainActivity, "Loading Page $page", Toast.LENGTH_SHORT).show()

                    }
                }

            }
        })

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

    private fun search(){
        search_view.setOnCloseListener {
            isSearchActive = false
            Log.d(TAG,"Close")
            return@setOnCloseListener false
        }
        search_view.setOnSearchClickListener {
            isSearchActive = true
            Log.d(TAG,"Open")
        }
        search_view.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchTitle(newText)
                return true
            }
        })
    }

}