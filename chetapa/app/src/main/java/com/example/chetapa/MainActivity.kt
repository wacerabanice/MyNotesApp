package com.example.chetapa



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.chetapa.navigation.AppNavHost
import com.example.chetapa.ui.theme.ChetapaTheme
import com.example.chetapa.ui.theme.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class  MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChetapaTheme {
                AppNavHost(viewModel)

                }
            }
        }
    }
