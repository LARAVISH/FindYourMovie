package com.example.findyourmovie.viewmodel

import com.example.findyourmovie.model.Cinema

sealed class AppState {

    data class Success(val cinema : Cinema) : AppState()
    object Loading : AppState()
    data class Error(val error: Throwable) : AppState()

}
