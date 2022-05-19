package com.example.findyourmovie.model


interface Repository {
    fun getMovieFromServer(): Cinema
    fun getMovieFromLocalStorage(): Cinema
}