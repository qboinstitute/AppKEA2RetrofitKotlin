package com.qbo.appkea2retrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.qbo.appkea2retrofitkotlin.adapter.AlbumAdapter
import com.qbo.appkea2retrofitkotlin.api.ApiServiceAlbum
import com.qbo.appkea2retrofitkotlin.model.Album
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var apiservice: ApiServiceAlbum
    private lateinit var rvalbum: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        rvalbum = findViewById(R.id.rvalbum)
        rvalbum.layoutManager = StaggeredGridLayoutManager(3,
            StaggeredGridLayoutManager.VERTICAL)
        apiservice = retrofit.create<ApiServiceAlbum>(ApiServiceAlbum::class.java)
        obtenerAlbum()
    }

    private fun obtenerAlbum() {
        apiservice.getAllPosts().enqueue(object: Callback<List<Album>>{
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                val albums = response?.body()
                rvalbum.adapter = AlbumAdapter(albums!!)
            }
            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }
}