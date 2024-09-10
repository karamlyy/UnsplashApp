package com.example.testapp.data.model

data class UnsplashPhoto(
    val id: String,
    val description: String?,
    val urls: Urls,
)

data class Urls (
    var small: String
)
