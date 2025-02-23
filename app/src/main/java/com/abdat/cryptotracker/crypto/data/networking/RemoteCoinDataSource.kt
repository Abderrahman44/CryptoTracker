package com.abdat.cryptotracker.crypto.data.networking

import com.abdat.cryptotracker.core.data.networking.HttpClientFactory
import com.abdat.cryptotracker.core.data.networking.constructUrl
import com.abdat.cryptotracker.core.data.networking.safeCall
import com.abdat.cryptotracker.core.domain.util.NetworkError
import com.abdat.cryptotracker.core.domain.util.Result
import com.abdat.cryptotracker.core.domain.util.map
import com.abdat.cryptotracker.crypto.data.mapper.toCoin
import com.abdat.cryptotracker.crypto.data.networking.dto.CoinResponseDto
import com.abdat.cryptotracker.crypto.domain.Coin
import com.abdat.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking

class RemoteCoinDataSource(
    private val httpClient: HttpClient,
): CoinDataSource {
    override suspend fun getCoins(): Result<NetworkError, List<Coin>> {
        return safeCall<CoinResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}

fun main(): Unit = runBlocking {
    val remoteCoinDataSource = RemoteCoinDataSource(HttpClientFactory.create(CIO.create()))
    println("Fetching coins...")
    // Use launch to start the coroutine concurrently
    val result = remoteCoinDataSource.getCoins()

        // Switch to the Main dispatcher for UI-related operations (like printing)
            when (result) {
                is Result.Success -> {
                    result.data.forEach { coin ->
                        println(coin.name)
                    }
                }
                is Result.Error -> {
                    println("Error: ${result.error}")
                }
            }
    println("Coins fetched")
}


