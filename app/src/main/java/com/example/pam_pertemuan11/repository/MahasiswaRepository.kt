package com.example.pam_pertemuan11.repository

import com.example.pam_pertemuan11.model.Mahasiswa
import com.example.pam_pertemuan11.service.MahasiswaService
import okio.IOException

interface MahasiswaRepository {
    suspend fun getMahasiswa(): List<Mahasiswa>
    suspend fun getMahasiswaById(nim : String) : Mahasiswa
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(nim: String)
}

class NetworkMahasiswaRepository(mahasiswaService: MahasiswaService) : MahasiswaRepository {
    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        mahasiswaApiService.inserMahasiswa(mahasiswa)
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        mahasiswaApiService.updateMahasiswa(nim, mahasiswa)
    }

    override suspend fun deleteMahasiswa(nim: String) {
        try {
            val response = mahasiswaApiService.deleteMahasiswa(nim)
            if (!response.isSuccessful) {
                throw IOException("Failed to delete mahasiswa. HTTP Status code: ${response.code()}")
            } else {
                response.message()
                println(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getMahasiswa(): List<Mahasiswa> = mahasiswaApiService.getMahasiswa()
    override suspend fun getMahasiswaById(nim: String): Mahasiswa {
        return mahasiswaApiService.getMahasiswaById(nim)
    }
}