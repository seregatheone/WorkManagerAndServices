package com.example.a19.data.retrofit

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

interface RequestService {
    @GET("fact")
    suspend fun getRequest(): Response<CatFactModelModel>
}

class RequestServiceImpl @Inject constructor(retrofit : Retrofit) : RequestService{
    private val ourRequestService: RequestService = retrofit.create(RequestService::class.java)
    override suspend fun getRequest(): Response<CatFactModelModel> = ourRequestService.getRequest()
}
