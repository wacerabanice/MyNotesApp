package net.pata.ui.theme.about

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import net.pata.ui.theme.auth.AuthViewModel


@Composable
fun About(viewModel: AuthViewModel?, navController: NavHostController) {

    Column {
        Text(text = "About Screen")
    }


}