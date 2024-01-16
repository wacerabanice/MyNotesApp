package net.pata



import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import net.pata.navigation.AppNavHost
import net.pata.ui.theme.PataTheme
import net.pata.ui.theme.auth.AuthViewModel



@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PataTheme {
                AppNavHost(viewModel)
            }
        }
    }
}