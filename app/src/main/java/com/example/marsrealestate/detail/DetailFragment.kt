package com.example.marsrealestate.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.marsrealestate.R
import com.example.marsrealestate.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val application = requireNotNull(activity).application

        // Inflate the layout for this fragment
        val binding = FragmentDetailBinding.inflate(inflater)

        val marsProperty = DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty

        val viewModelFactory = DetailViewModelFactory(marsProperty, application)

        binding.viewModel = ViewModelProvider(this, viewModelFactory)[DetailViewModel::class.java]

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this


        return binding.root
    }
}