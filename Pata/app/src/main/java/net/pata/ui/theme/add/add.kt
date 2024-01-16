package net.pata.ui.theme.add

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import net.pata.ui.theme.auth.AuthViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Addscreen(viewModel: AuthViewModel?, navController: NavController) {


    var firebaseDatabase = FirebaseDatabase.getInstance().getReference("Data")
        .child("Name");

    // on below line we are calling method to display UI
    firebaseUI(LocalContext.current, firebaseDatabase)

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun firebaseUI(context: Context, databaseReference: DatabaseReference) {

        val name = remember {
            mutableStateOf(TextFieldValue())
        }

        val contactNumber = remember {
            mutableStateOf(TextFieldValue())
        }

        var salespermonth = remember {
            mutableStateOf("")
        }

        var bankingspermonth = remember {
            mutableStateOf("")
        }
    }
}

fun firebaseUI(current: Context, firebaseDatabase: DatabaseReference) {

}
