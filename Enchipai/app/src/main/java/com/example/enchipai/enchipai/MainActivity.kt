package com.example.enchipai.enchipai

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.enchipai.enchipai.auth.AuthViewModel
import com.example.enchipai.enchipai.navigation.AppNavHost
import com.example.enchipai.enchipai.ui.theme.EnchipaiTheme
import dagger.hilt.android.AndroidEntryPoint
import navigation.AppNavHost
import kotlin.text.Typography.dagger


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnchipaiTheme {
                AppNavHost(viewModel)
            }
        }
    }
}
