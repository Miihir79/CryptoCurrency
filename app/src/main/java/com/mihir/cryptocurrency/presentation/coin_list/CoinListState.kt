package com.mihir.cryptocurrency.presentation.coin_list

import com.mihir.cryptocurrency.domain.model.Coin

data class CoinListState( val isLoading:Boolean = false,
val coins:List<Coin> = emptyList(),
val error:String=""){

}
