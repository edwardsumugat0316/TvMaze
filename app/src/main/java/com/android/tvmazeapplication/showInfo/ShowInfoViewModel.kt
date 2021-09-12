package com.android.tvmazeapplication.showInfo

import androidx.lifecycle.*
import com.android.tvmazeapplication.model.ShowEntity
import com.android.tvmazeapplication.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShowInfoViewModel(id: Int, private val repository: Repository): ViewModel() {

    val showInfo: LiveData<ShowEntity> = liveData(Dispatchers.IO){
        load.postValue(true)
        emit(repository.getShowInfo(id = id))
    }

    val load = MutableLiveData<Boolean>()

    fun saveShowFrmDb(show: ShowEntity){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.saveShowFrmDb(show)
            }
        }
    }

    fun getShowFromDb(id: Int): ShowEntity {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.getShowFrmDb(id)
            }
        }
        return repository.getShowFrmDb(id)
    }
}