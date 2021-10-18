package com.android.tvmazeapplication.EpisodeInfoActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.android.tvmazeapplication.model.episode.EpisodeEntity
import com.android.tvmazeapplication.repository.Repository
import kotlinx.coroutines.Dispatchers

class EpisodeInfoViewModel(val episodeId: Int, repository: Repository): ViewModel() {

    val episodeInfo: LiveData<EpisodeEntity> = liveData(Dispatchers.IO){
        load.postValue(true)
        emit(repository.getEpisodeId(episodeId))
    }
    val load = MutableLiveData<Boolean>()
}