package com.qbo.appkea2retrofitkotlin.api

import com.qbo.appkea2retrofitkotlin.model.Album
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceAlbum {

    @GET("albums")
    fun getAllPosts(): Call<List<Album>>

}