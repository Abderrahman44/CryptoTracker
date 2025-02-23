package com.abdat.cryptotracker

import com.abdat.cryptotracker.crypto.data.mapper.toCoin
import com.abdat.cryptotracker.crypto.data.networking.RemoteCoinDataSource
import com.abdat.cryptotracker.crypto.data.networking.dto.CoinDto
import com.abdat.cryptotracker.crypto.data.networking.dto.CoinResponseDto
import io.ktor.client.HttpClient
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class TestRemoteCoinDataSource {
    private val httpClient = mockk<HttpClient>()
    private val remoteCoinDataSource = RemoteCoinDataSource(httpClient)

    @Test
    fun `getCoins should return list of coins on success`() = runTest {}
}