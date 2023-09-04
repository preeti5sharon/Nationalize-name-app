package com.example.nationalizeapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NationaliseViewModel @Inject constructor(private val repository: NationaliseRepository) :
    ViewModel() {
    private var _nationalList = MutableStateFlow<NationaliseResponse?>(null)
    val nationalList = _nationalList.asStateFlow()
    fun getNationalised(name: String) = viewModelScope.launch(Dispatchers.IO) {
        _nationalList.value = repository.getNationalised(name).body()
    }
}
