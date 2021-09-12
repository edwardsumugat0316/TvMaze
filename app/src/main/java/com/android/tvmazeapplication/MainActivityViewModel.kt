package com.android.tvmazeapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.tvmazeapplication.model.ShowEntity
import com.android.tvmazeapplication.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(private val repository: Repository): ViewModel() {

    val showListLiveData: MutableLiveData<List<ShowEntity>> = MutableLiveData()

    fun loadingShows(page: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val shows = repository.getShows(page)
                withContext(Dispatchers.Main){
                    showListLiveData.value = shows
                }

//                showList.enqueue(object : retrofit2.Callback <List<ShowStructureItem>> {
//                    override fun onResponse( call: Call<List<ShowStructureItem>>, response: Response<List<ShowStructureItem>>) {
//                        showListLiveData.postValue(response.body())
//                    }
//
//                    override fun onFailure(call: Call<List<ShowStructureItem>>, t: Throwable) {
//                        showListLiveData.postValue(null)
//                    }
//                })
            }
        }
    }

}