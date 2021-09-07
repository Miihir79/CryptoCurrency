package com.mihir.cryptocurrency.data.repository

import com.mihir.cryptocurrency.data.remote.CoinPaprikaAPI
import com.mihir.cryptocurrency.data.remote.dto.CoinDTO
import com.mihir.cryptocurrency.data.remote.dto.CoinDetailDTO
import com.mihir.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepoImpl @Inject constructor(
    private val api: CoinPaprikaAPI
):CoinRepository {
    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }


}