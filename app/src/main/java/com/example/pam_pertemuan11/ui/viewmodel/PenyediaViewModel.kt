package com.example.pam_pertemuan11.ui.viewmodel

import android.text.Editable.Factory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pam_pertemuan11.MahasiswaApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiMahasiswa().container.mahasiswaRepository) }
        initializer { InsertViewModel(aplikasiMahasiswa().container.mahasiswaRepository) }
        initializer {
            val savedStateHandle = createSavedStateHandle()
            DetailViewModel(savedStateHandle, aplikasiMahasiswa().container.mahasiswaRepository)
        }
        initializer { UpdateViewModel(aplikasiMahasiswa().container.mahasiswaRepository) }
    }
}

fun CreationExtras.aplikasiMahasiswa(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)