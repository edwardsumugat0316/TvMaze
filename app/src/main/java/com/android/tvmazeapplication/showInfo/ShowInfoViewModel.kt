package com.android.tvmazeapplication.showInfo

import androidx.lifecycle.*
import com.android.tvmazeapplication.model.ShowEntity
import com.android.tvmazeapplication.model.episode.EpisodeEntity
import com.android.tvmazeapplication.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShowInfoViewModel(id: Int, private val repository: Repository): ViewModel() {

    val showInfo: LiveData<ShowEntity> = liveData(Dispatchers.IO){
        load.postValue(true)
        emit(repository.getShowInfo(id = id))
    }
    private val load = MutableLiveData<Boolean>()

    val episodesLiveData: MutableLiveData<List<EpisodeEntity>> = MutableLiveData()

    fun episodeList(showId: Int?){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val episodes = repository.getEpisodes(showId)
                withContext(Dispatchers.Main){
                    episodesLiveData.value = episodes
                }
            }
        }
    }

}