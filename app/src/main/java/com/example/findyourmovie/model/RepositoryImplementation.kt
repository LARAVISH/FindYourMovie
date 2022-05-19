package com.example.findyourmovie.model

class RepositoryImplementation : Repository {

    override fun getMovieFromServer() : Cinema{
        return Cinema()
    }
    override fun getMovieFromLocalStorage() : Cinema{
        return Cinema()
    }
}