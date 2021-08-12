package com.android.tvmazeapplication.showInfo

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TableLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.viewpager2.widget.ViewPager2
import com.android.tvmazeapplication.MainActivity
import com.android.tvmazeapplication.R
import com.android.tvmazeapplication.adapter.ViewPagerAdapter
import com.android.tvmazeapplication.base.BaseActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.show_info_activity.*

class ShowInfoActivity: BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_info_activity)

        val showIntent = intent.getStringExtra("ShowInfo")

        setupNavigationDrawer()

        val tableLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager2.adapter = adapter

        TabLayoutMediator(tableLayout,viewPager2){tab, position ->
            when(position){
                0->{
                    tab.text = "Show Information"
                }
                1->
                    tab.text = "Wait Lang"
            }
        }.attach()

    }

    private fun setupNavigationDrawer(){
        val toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open, R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white))
        toggle.syncState()

        nav_menu.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)

        when(item.itemId){
            R.id.home -> {
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
        return true
    }
}