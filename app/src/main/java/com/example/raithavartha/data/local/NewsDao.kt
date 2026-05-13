package com.example.raithavartha.data.local

import androidx.room.*
import com.example.raithavartha.data.model.NewsArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM news_articles ORDER BY date DESC")
    fun getAllNews(): Flow<List<NewsArticle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(articles: List<NewsArticle>)

    @Query("DELETE FROM news_articles")
    suspend fun deleteAllNews()
}
