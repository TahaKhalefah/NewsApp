package com.tahadroid.newsapp.repository

import androidx.lifecycle.MutableLiveData
import com.tahadroid.newsapp.data.remote.ApiManager
import com.tahadroid.newsapp.pojo.headlines.ArticlesItem
import com.tahadroid.newsapp.pojo.headlines.HeadlinesResponse
import com.tahadroid.newsapp.pojo.sources.SourcesItem
import com.tahadroid.newsapp.pojo.sources.SourcesResponse
import com.tahadroid.newsapp.ui.home.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    fun getSources() : MutableLiveData<List<SourcesItem>>{
        val _sources = MutableLiveData<List<SourcesItem>>()
        ApiManager.apiServices.getSources(API_KEY).enqueue(object : Callback<SourcesResponse> {
            override fun onFailure(call: Call<SourcesResponse>, t: Throwable) {
//                _errorMessage.value = t.message
            }

            override fun onResponse(
                call: Call<SourcesResponse>,
                response: Response<SourcesResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.sources?.let {
                        _sources.value = it
                    }
                }

            }

        })
        return _sources
    }
    fun getHeadlines(name:String) :MutableLiveData<List<ArticlesItem>>{
        val _headlines=MutableLiveData<List<ArticlesItem>>()
        ApiManager.apiServices.getHeadlines(
            name,
            API_KEY
        )
            .enqueue(object : Callback<HeadlinesResponse> {
                override fun onFailure(call: Call<HeadlinesResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<HeadlinesResponse>,
                    response: Response<HeadlinesResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.articles?.let {
                            _headlines.value=it
                        }
                    }
                }

            })
        return _headlines
    }
}