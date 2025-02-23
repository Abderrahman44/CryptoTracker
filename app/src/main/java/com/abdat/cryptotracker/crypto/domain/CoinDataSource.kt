package com.abdat.cryptotracker.crypto.domain

import com.abdat.cryptotracker.core.domain.util.NetworkError
import com.abdat.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<NetworkError,List<Coin>>
}