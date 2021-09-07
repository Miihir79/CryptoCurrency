package com.mihir.cryptocurrency.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.mihir.cryptocurrency.domain.model.Coin

data class CoinDTO (
    val id:String,
    @SerializedName("is_active")
    val isActive:Boolean,
    @SerializedName("is_new")
    val isNew:Boolean,
    val name:String,
    val rank:String,
    val symbol:String,
    val type:String
)

fun CoinDTO.toCoin(): Coin {
    return Coin( id,
     isActive,
    name, rank, symbol)
}