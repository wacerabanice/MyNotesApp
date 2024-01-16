package com.example.chipai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.chipai.navigation.AppNavHost
import com.example.chipai.ui.theme.ChipaiTheme
import com.example.chipai.ui.theme.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChipaiTheme {
                AppNavHost(viewModel)

            }
        }
    }
}


