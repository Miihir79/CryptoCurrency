package com.mihir.cryptocurrency.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mihir.cryptocurrency.common.Constants.PARAM_COIN_ID
import com.mihir.cryptocurrency.common.Resource
import com.mihir.cryptocurrency.domain.use_cases.get_coin.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase,
private val savedStateHandle:SavedStateHandle):ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state
    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId->
            getCoins(coinId)
        }
    }

    private fun getCoins(coinId:String){
        getCoinsUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Success ->{
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error->{
                    _state.value = CoinDetailState(error = result.message?:"Error")
                }
                is Resource.Loading->{
                    _state.value = CoinDetailState(true)
                }
            }
        }.launchIn(viewModelScope)
    }
}