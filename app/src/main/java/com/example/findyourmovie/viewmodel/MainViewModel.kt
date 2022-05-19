package com.example.findyourmovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.findyourmovie.model.RepositoryImplementation
import java.lang.Thread.sleep

class MainViewModel(
    private val laveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImplementation = RepositoryImplementation()
) :
    ViewModel() {

    fun getLaveData(): LiveData<AppState> = laveData

    fun getCinema() {
        laveData.postValue(AppState.Loading)
        Thread {
            sleep(2000)
            val ran = (0..40).random()
            if (ran > 20) {
                laveData.postValue(AppState.Success(repository.getMovieFromServer()))
            } else {
                laveData.postValue(AppState.Error(IllegalArgumentException()))
            }


        }.start()
    }

}