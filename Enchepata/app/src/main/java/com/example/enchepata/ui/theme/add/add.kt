package com.example.enchepata.ui.theme.add

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.enchepata.ui.theme.auth.AuthViewModel
import com.google.firebase.database.FirebaseDatabase

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Addscreen(viewModel: AuthViewModel?, navController: NavController){


    var firebaseDatabase = FirebaseDatabase.getInstance().getReference("Data")
        .child("Name");

    // on below line we are calling method to display UI
    firebaseUI(LocalContext.current, firebaseDatabase )



}

