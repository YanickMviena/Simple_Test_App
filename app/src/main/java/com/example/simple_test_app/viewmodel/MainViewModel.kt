package com.example.simple_test_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simple_test_app.model.AmiiboResponse
import com.example.simple_test_app.remote.AmiiboRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val amiiboRepository: AmiiboRepository
) : ViewModel() {

    private val _amiiboList: MutableStateFlow<List<AmiiboResponse>> = MutableStateFlow(emptyList())
    val amiiboList: StateFlow<List<AmiiboResponse>> get() = _amiiboList.asStateFlow()

    init {
        // doing this internally for demo
        fetchAmiiboListData()
    }

    fun fetchAmiiboListData() {
        viewModelScope.launch {
            val response = amiiboRepository.fetchData()
            if (response.isSuccessful) {
               response.body()?.let { body ->
                   _amiiboList.value = body
               }
            }
        }
    }
}