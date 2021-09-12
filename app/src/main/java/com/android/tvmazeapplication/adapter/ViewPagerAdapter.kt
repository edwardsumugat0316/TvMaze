package com.android.tvmazeapplication.adapter

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.tvmazeapplication.R
import com.android.tvmazeapplication.base.BaseActivity
import com.android.tvmazeapplication.showInfo.ShowInfoActivity
import com.android.tvmazeapplication.showInfo.ShowInfoFragment
import com.android.tvmazeapplication.showInfo.TentativeFragment

class ViewPagerAdapter(private val fragmentManager: FragmentManager, lifecycle: Lifecycle, val showId: Int ) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0->{
                val bundle = Bundle()
                bundle.putInt("ShowId",showId)
                val fragmentObject = ShowInfoFragment()
                fragmentObject.arguments = bundle
                fragmentObject
            }
            1->{
                TentativeFragment()
            }
            else->{
                Fragment()
            }
        }
    }
//
//    fun bundle(){
//        val bundle = Bundle()
//        bundle.putInt("ShowId",0)
//        val fragmentObject = ShowInfoFragment()
//        fragmentObject.arguments = bundle
//        val fm: FragmentManager =
//        fm.beginTransaction().add(R.id.content_main, fragmentObject).commit()
//    }


}