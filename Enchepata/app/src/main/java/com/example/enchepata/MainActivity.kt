package com.example.enchepata

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.enchepata.navigation.AppNavHost
import com.example.enchepata.ui.theme.auth.AuthViewModel
import com.example.enchepata.ui.theme.theme.EnchepataTheme






@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnchepataTheme {
                AppNavHost(viewModel)

            }
        }
    }
}

annotation class AndroidEntryPoint

