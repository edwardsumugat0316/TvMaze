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

    val searchLiveData: MutableLiveData<List<ShowEntity>> = MutableLiveData()

    fun loadingShows(page: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val shows = repository.getShows(page)

                withContext(Dispatchers.Main){
                    showListLiveData.value = shows
                }

            }
        }
    }

    fun searchTitle(title: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val searchTitle = repository.searchTitle(title)

                withContext(Dispatchers.Main){
                    searchLiveData.value = searchTitle
                }
            }
        }
    }
}