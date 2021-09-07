package com.mihir.cryptocurrency.domain.repository

import com.mihir.cryptocurrency.data.remote.dto.CoinDTO
import com.mihir.cryptocurrency.data.remote.dto.CoinDetailDTO

interface CoinRepository {
    suspend fun getCoins():List<CoinDTO>
    suspend fun getCoinById(coinId:String):CoinDetailDTO
}