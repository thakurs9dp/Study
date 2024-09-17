package com.s9dp.study.kotlin.st_1_class

// Sealed class is

sealed class UIState {
    object Loading : UIState()
    data class Success(val data: String) : UIState()
    data class Error(val error: IllegalStateException) : UIState()
}


fun showLoadingState(uiState: UIState) {
    when (uiState) {
        UIState.Loading -> println("Loading starts")
        is UIState.Success -> println("Test value")
        is UIState.Error -> println(IllegalStateException())
    }
}


fun main() {

    val loadingState = UIState.Loading
    showLoadingState(loadingState)

    val successData = UIState.Success("Data getting")
    showLoadingState(successData)

    val errorState = UIState.Error(IllegalStateException())
    showLoadingState(errorState)

}

