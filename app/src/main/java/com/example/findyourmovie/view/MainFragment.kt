package com.example.findyourmovie.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.findyourmovie.R
import com.example.findyourmovie.databinding.FragmentMainBinding
import com.example.findyourmovie.viewmodel.AppState
import com.example.findyourmovie.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLaveData().observe(viewLifecycleOwner, Observer<AppState> { renderData(it) })
        viewModel.getCinema()
    }

    private fun renderData(appState: AppState) = with(binding) {
            loadingLayout.visibility = View.VISIBLE
        when (appState) {

            AppState.Loading -> loadingLayout.visibility = View.VISIBLE

            is AppState.Success ->{
                loadingLayout.visibility = View.GONE
                Snackbar.make(mainView,appState.cinema.title,Snackbar.LENGTH_LONG).show()
            }
            is AppState.Error ->{
                loadingLayout.visibility = View.GONE
                Snackbar.make(mainView,"Error",Snackbar.LENGTH_LONG).setAction("Try again"){
                    viewModel.getCinema()
                }.show()
            }
        }

    }


    companion object {

        fun newInstance() =
            MainFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
