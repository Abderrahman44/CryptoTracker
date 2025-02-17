package com.abdat.cryptotracker.crypto.presentation.coin_list

import com.abdat.cryptotracker.crypto.presentation.models.CoinUi

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null
)