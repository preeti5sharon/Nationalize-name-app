package com.example.nationalizeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.nationalizeapp.databinding.FragmentNationaliseBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NationaliseFragment : Fragment() {

    private var binding: FragmentNationaliseBinding? = null
    private val viewModel: NationaliseViewModel by viewModels()
    private val adapter = NationaliseAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentNationaliseBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.searchButton?.setOnClickListener {
            val searchName = binding?.nameEt?.text.toString()
            viewModel.getNationalised(searchName)
        }
        lifecycleScope.launch {
            viewModel.nationalList.collectLatest {
                val countryList = it?.country
                adapter.asyncDiffer.submitList(countryList)
            }
        }
        binding?.recyclerView?.adapter = adapter
    }
}
