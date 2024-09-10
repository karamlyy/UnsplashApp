package com.example.testapp.data.api

import com.example.testapp.data.model.UnsplashPhoto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization: Client-ID 1EQdPeyDlcD6p8sJdoIPWZ9pzaw8gYTtm-UOnV0mRqI")
    @GET("/photos")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ) : Response<List<UnsplashPhoto>>

}