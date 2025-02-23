package com.abdat.cryptotracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abdat.cryptotracker.crypto.presentation.coin_list.CoinListScreen
import com.abdat.cryptotracker.crypto.presentation.coin_list.CoinListVM
import com.abdat.cryptotracker.ui.theme.CryptoTrackerTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel = koinViewModel<CoinListVM>()
                    val state = viewModel.state.collectAsStateWithLifecycle()
                    CoinListScreen(
                        state = state.value,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
