package com.android.tvmazeapplication.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.tvmazeapplication.showInfo.ShowInfoFragment
import com.android.tvmazeapplication.showInfo.EpisodeFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val showId: Int) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0->{
                val bundle = Bundle()
                bundle.putInt("ShowId",showId)
                val showFragment = ShowInfoFragment()
                showFragment.arguments = bundle
                showFragment
            }
            1->{
                val bundle = Bundle()
                bundle.putInt("ShowId",showId)
                val episodeFragment = EpisodeFragment()
                episodeFragment.arguments = bundle
                episodeFragment
            }
            else->{
                Fragment()
            }
        }
    }

}