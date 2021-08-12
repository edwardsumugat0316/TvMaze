package com.android.tvmazeapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.android.tvmazeapplication.model.ShowStructureItem
import com.android.tvmazeapplication.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivityViewModel(private val repository: Repository): ViewModel() {

    val showListLiveData: MutableLiveData<List<ShowStructureItem>> = MutableLiveData()

    fun saveShowsFromDb(shows: List<ShowStructureItem>){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.insertShows(shows)
            }
        }
    }

    fun loadingShows(page: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val showList = repository.getShows(page)
                showList.enqueue(object : retrofit2.Callback <List<ShowStructureItem>> {
                    override fun onResponse( call: Call<List<ShowStructureItem>>, response: Response<List<ShowStructureItem>>) {
                        showListLiveData.postValue(response.body())
                    }

                    override fun onFailure(call: Call<List<ShowStructureItem>>, t: Throwable) {
                        showListLiveData.postValue(null)
                    }
                })
            }
        }
    }

}