package com.example.raithavartha.data.repository

import com.example.raithavartha.data.local.NewsDao
import com.example.raithavartha.data.model.NewsArticle
import kotlinx.coroutines.flow.Flow

class NewsRepository(private val newsDao: NewsDao) {
    val allNews: Flow<List<NewsArticle>> = newsDao.getAllNews()

    suspend fun refreshNews() {
        // In a real app, fetch from API. Here we simulate with dummy data.
        val dummyNews = listOf(
            NewsArticle(
                titleEn = "New Irrigation Subsidy Announced",
                titleKn = "ಹೊಸ ನೀರಾವರಿ ಸಹಾಯಧನ ಘೋಷಣೆ",
                descriptionEn = "Karnataka government announces 90% subsidy for drip irrigation.",
                descriptionKn = "ಹನಿ ನೀರಾವರಿಗೆ ಶೇ.90ರಷ್ಟು ಸಹಾಯಧನ ನೀಡಲಾಗುವುದು ಎಂದು ಕರ್ನಾಟಕ ಸರ್ಕಾರ ಘೋಷಿಸಿದೆ.",
                imageUrl = "https://example.com/irrigation.jpg",
                date = "2023-10-27"
            ),
            NewsArticle(
                titleEn = "Monsoon Outlook for Farmers",
                titleKn = "ರೈತರಿಗೆ ಮುಂಗಾರು ಮುನ್ಸೂಚನೆ",
                descriptionEn = "Expected normal rainfall in most parts of Karnataka.",
                descriptionKn = "ಕರ್ನಾಟಕದ ಬಹುತೇಕ ಭಾಗಗಳಲ್ಲಿ ಸಾಮಾನ್ಯ ಮಳೆಯಾಗುವ ನಿರೀಕ್ಷೆಯಿದೆ.",
                imageUrl = "https://example.com/monsoon.jpg",
                date = "2023-10-26"
            )
        )
        newsDao.insertNews(dummyNews)
    }
}
