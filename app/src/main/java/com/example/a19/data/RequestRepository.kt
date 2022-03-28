package com.example.a19.data

import com.example.a19.data.retrofit.RequestServiceImpl
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private val requestsService: RequestServiceImpl) {
    suspend fun getUsers() = requestsService.getRequest()
}