package com.example.chetapa.ui.theme.auth.about


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.chetapa.ui.theme.auth.AuthViewModel


@Composable
fun About(viewModel: AuthViewModel?, navController: NavHostController) {

    Column {
        Text(text = "About Screen")
    }


}