package com.example.raithavartha.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ExpertAskUiState(
    val imageUri: Uri? = null,
    val question: String = "",
    val isSubmitting: Boolean = false,
    val suggestions: List<String> = emptyList(),
    val error: String? = null
)

class ExpertAskViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ExpertAskUiState())
    val uiState: StateFlow<ExpertAskUiState> = _uiState.asStateFlow()

    fun onImageSelected(uri: Uri?) {
        _uiState.value = _uiState.value.copy(imageUri = uri, suggestions = emptyList(), error = null)
    }

    fun onQuestionChanged(newQuestion: String) {
        _uiState.value = _uiState.value.copy(question = newQuestion)
    }

    fun submitQuestion() {
        val currentState = _uiState.value
        if (currentState.imageUri == null) {
            _uiState.value = currentState.copy(error = "Please upload a crop image first.")
            return
        }
        if (currentState.question.isBlank()) {
            _uiState.value = currentState.copy(error = "Please enter your question.")
            return
        }

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isSubmitting = true, error = null, suggestions = emptyList())
            
            // Simulating AI Processing
            delay(2000)
            
            val dummySuggestions = listOf(
                "Possible leaf infection detected.",
                "Use neem oil spray.",
                "Reduce excess watering."
            )
            
            _uiState.value = _uiState.value.copy(
                isSubmitting = false,
                suggestions = dummySuggestions
            )
        }
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }

    fun reset() {
        _uiState.value = ExpertAskUiState()
    }
}
