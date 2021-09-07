package com.mihir.cryptocurrency.domain.model



data class Coin(
    val id:String,
    val isActive:Boolean,
    val name:String,
    val rank:String,
    val symbol:String,
)
