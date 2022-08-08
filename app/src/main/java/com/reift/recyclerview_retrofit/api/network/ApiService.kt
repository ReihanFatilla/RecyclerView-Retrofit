package com.reift.recyclerview_retrofit.api.network

import com.reift.recyclerview_retrofit.api.data.UserItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @GET("users")
    fun getListUser()
    : Call<List<UserItem>>
}