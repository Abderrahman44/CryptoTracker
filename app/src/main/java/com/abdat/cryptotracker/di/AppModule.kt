package com.abdat.cryptotracker.di

import com.abdat.cryptotracker.core.data.networking.HttpClientFactory
import com.abdat.cryptotracker.crypto.data.networking.RemoteCoinDataSource
import com.abdat.cryptotracker.crypto.domain.CoinDataSource
import com.abdat.cryptotracker.crypto.presentation.coin_list.CoinListVM
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

import org.koin.dsl.module

val appModule = module {
    /*single{ HttpClientFactory.create(CIO.create())}
    single <CoinDataSource>{RemoteCoinDataSource(httpClient = get())}
    viewModelOf(::CoinListVM)*/
   //viewModel { CoinListVM(coinDataSource = get()) }
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListVM)
}