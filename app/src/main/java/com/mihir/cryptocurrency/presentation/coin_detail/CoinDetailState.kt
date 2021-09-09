package com.mihir.cryptocurrency.presentation.coin_detail

import com.mihir.cryptocurrency.domain.model.Coin
import com.mihir.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(val isLoading:Boolean = false,
                           val coin:CoinDetail?=null,
                           val error:String=""){

}
