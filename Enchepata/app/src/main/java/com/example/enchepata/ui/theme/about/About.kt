package com.example.enchepata.ui.theme.about

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.enchepata.ui.theme.auth.AuthViewModel




@Composable
fun About(viewModel: AuthViewModel?, navController: NavHostController) {

    Column {
        Text(text = "Learn More About Loans")
    }

    Column {
        Text(text = "Working Capital Loans Explained")
        Text(text = "Asset Finance Loans Explained")
        Text(text = "Mortgage Loans Explained")
    }


}