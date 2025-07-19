package com.vineesh.newsapp.data.remote
import com.vineesh.newsapp.data.remote.dto.NewsResponse
import com.vineesh.newsapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = Constants.apiKey
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = Constants.apiKey
    ): NewsResponse
}