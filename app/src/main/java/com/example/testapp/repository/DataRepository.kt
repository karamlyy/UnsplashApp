package com.example.testapp.repository

import com.example.testapp.data.api.RetrofitInstance

class DataRepository {
    suspend fun getPhotos(page: Int, perPage: Int) = RetrofitInstance.api.getPhotos(page, perPage)
}