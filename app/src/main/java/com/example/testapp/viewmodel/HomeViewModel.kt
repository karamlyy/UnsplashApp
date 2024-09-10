package com.example.testapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.model.UnsplashPhoto
import com.example.testapp.repository.DataRepository
import kotlinx.coroutines.launch

class HomeViewModel (private val repository: DataRepository) : ViewModel() {

    private val _photos = MutableLiveData<List<UnsplashPhoto>>()
    val photos: LiveData<List<UnsplashPhoto>> get() = _photos

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private var currentPage = 1
    private var isFetching = false

    init {
        fetchPhotos(currentPage, 10)
    }

    fun fetchPhotos(page: Int, perPage: Int) {
        if (isFetching) return
        isFetching = true
        _isLoading.value = true

        viewModelScope.launch {
            val response = repository.getPhotos(page, perPage)
            if (response.isSuccessful) {
                response.body()?.let { newPhotos ->
                    val updatedPhotos = _photos.value.orEmpty() + newPhotos
                    _photos.postValue(updatedPhotos)
                }
            }
            _isLoading.value = false
            isFetching = false
        }
    }

    fun loadNextPage() {
        currentPage += 1
        fetchPhotos(currentPage, 10)
    }


}