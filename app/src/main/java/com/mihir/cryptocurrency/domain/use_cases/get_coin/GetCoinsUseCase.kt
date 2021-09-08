package com.mihir.cryptocurrency.domain.use_cases.get_coin

import com.mihir.cryptocurrency.common.Resource
import com.mihir.cryptocurrency.data.remote.dto.toCoinDetail
import com.mihir.cryptocurrency.domain.model.CoinDetail
import com.mihir.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository:CoinRepository) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin  = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach the server"))
        }
    }
}