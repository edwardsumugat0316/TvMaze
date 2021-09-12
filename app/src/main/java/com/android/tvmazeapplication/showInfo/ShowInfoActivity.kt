package com.android.tvmazeapplication.showInfo

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
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
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ShowInfoActivity: BaseActivity() {
    private val viewModel: ShowInfoViewModel by viewModel { parametersOf(intent.getIntExtra("ShowId", 0)) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_info_activity)

//        val fragment = ShowInfoFragment.newInstance(showId)
//        val bundle = Bundle()
//        bundle.putInt("ShowId",showId)
//        val fragmentObject = ShowInfoFragment()
//        fragmentObject.arguments = bundle
//        val fm: FragmentManager = supportFragmentManager
//        fm.beginTransaction().add(R.id.content_main, fragmentObject).commit()
        val showId = intent.getIntExtra("ShowId", 0)
        val tableLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle,showId)

        viewPager2.adapter = adapter

        TabLayoutMediator(tableLayout, viewPager2){ tab, position ->
            when(position){
                0 -> {
                    tab.text = "Show Information"
                }
                1 ->
                    tab.text = "Episode"
            }
        }.attach()

    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }


}