package com.example.chepata.chepata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.chepata.chepata.navigation.AppNavHost
import com.example.chepata.chepata.ui.theme.ChepataTheme
import com.example.chepata.chepata.ui.theme.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChepataTheme {
                AppNavHost(viewModel)

            }
        }
    }
}


