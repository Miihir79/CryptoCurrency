package com.mihir.cryptocurrency.data.remote

import com.mihir.cryptocurrency.data.remote.dto.CoinDTO
import com.mihir.cryptocurrency.data.remote.dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDTO>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String):CoinDetailDTO
}