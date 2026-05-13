package com.example.raithavartha.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.raithavartha.data.local.AppDatabase
import com.example.raithavartha.data.model.NewsArticle
import com.example.raithavartha.data.repository.NewsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NewsRepository
    val allNews: StateFlow<List<NewsArticle>>

    init {
        val newsDao = AppDatabase.getDatabase(application).newsDao()
        repository = NewsRepository(newsDao)
        allNews = repository.allNews.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
        refreshNews()
    }

    fun refreshNews() {
        viewModelScope.launch {
            repository.refreshNews()
        }
    }
}
