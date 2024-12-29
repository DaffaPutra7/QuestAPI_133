package com.example.pam_pertemuan11

import android.app.Application
import com.example.pam_pertemuan11.repository.AppContainer
import com.example.pam_pertemuan11.repository.MahasiswaContainer

class MahasiswaApplications: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}