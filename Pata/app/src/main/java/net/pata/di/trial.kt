package net.pata.di

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()
Scaffold(Modifier.fillMaxSize(), snackbarHost = {
    SnackbarHost(snackbarHostState) { data ->
        Snackbar(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(data.visuals.message)
        }
    }
}) {
    Column(
        modifier = Modifier
            .padding(it)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = textFieldState,
            label = { Text("Enter your name") },
            onValueChange = {
                textFieldState = it
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            scope.launch {
                snackbarHostState.showSnackbar("My name is $textFieldState")
            }
        }) {
            Text("Show my name")
        }


    }
}
}
}
}