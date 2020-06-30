package com.tahadroid.newsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tahadroid.newsapp.pojo.headlines.ArticlesItem
import com.tahadroid.newsapp.repository.NewsRepository


class HomeViewModel : ViewModel() {
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage
    private var _headlines = MutableLiveData<List<ArticlesItem>>()
    val headlines: LiveData<List<ArticlesItem>> get() = _headlines

    val newsRepository =NewsRepository()
     fun getSources() =newsRepository.getSources()
     fun getHeadlines(name:String)  = newsRepository.getHeadlines(name)
}