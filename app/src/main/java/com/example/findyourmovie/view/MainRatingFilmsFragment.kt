package com.example.findyourmovie.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.findyourmovie.R


class MainRatingFilmsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main_rating_films, container, false)
    }

    companion object {

        fun newInstance() =
            MainRatingFilmsFragment()
    }
}
