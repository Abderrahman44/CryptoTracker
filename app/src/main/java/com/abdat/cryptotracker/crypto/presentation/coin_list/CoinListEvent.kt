package com.abdat.cryptotracker.crypto.presentation.coin_list

import com.abdat.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}