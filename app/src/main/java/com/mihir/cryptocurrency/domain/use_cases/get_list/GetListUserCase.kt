package com.mihir.cryptocurrency.domain.use_cases.get_list

import com.mihir.cryptocurrency.common.Resource
import com.mihir.cryptocurrency.data.remote.dto.toCoin
import com.mihir.cryptocurrency.domain.model.Coin
import com.mihir.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetListUserCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins  = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach the server"))
        }
    }
}