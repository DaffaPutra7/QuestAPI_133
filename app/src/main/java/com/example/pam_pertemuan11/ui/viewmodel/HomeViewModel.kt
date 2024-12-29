package com.example.pam_pertemuan11.ui.viewmodel

import com.example.pam_pertemuan11.model.Mahasiswa

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}

class HomeViewModel {
}