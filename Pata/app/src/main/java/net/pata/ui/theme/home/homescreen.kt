package net.pata.ui.theme.home


import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.pata.R
import net.pata.data.Resource
import net.pata.navigation.ROUTE_ABOUT
import net.pata.navigation.ROUTE_HOME
import net.pata.navigation.ROUTE_LOGIN
import net.pata.navigation.ROUTE_REGISTER
import net.pata.ui.theme.PataTheme
import net.pata.ui.theme.auth.AuthHeader
import net.pata.ui.theme.auth.AuthViewModel
import net.pata.ui.theme.spacing



@Composable
fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }


        val homeFlow = viewModel?.homeFlow?.collectAsState()


        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (refHeader, refButtonLogout, refButtonLogin, refButtonRegister,
                refTextAbout, refLoader) = createRefs()
            val spacing = MaterialTheme.spacing

            Box(
                modifier = Modifier
                    .constrainAs(refHeader) {
                        top.linkTo(parent.top, spacing.extraLarge)
                        start.linkTo(parent.start, spacing.extraLarge)
                        end.linkTo(parent.end, spacing.extraLarge)
                        width = Dimension.fillToConstraints
                    }
                    .wrapContentSize()
            ) {
                AuthHeader()
            }


            Button(
                onClick = {
                    viewModel?.login(email, password)
                    navController.navigate(ROUTE_LOGIN) {
                        popUpTo(ROUTE_HOME) { inclusive = true }
                    }
                },
                modifier = Modifier.constrainAs(refButtonLogin) {
                    top.linkTo(refHeader.bottom, spacing.extraLarge)
                    start.linkTo(parent.start, spacing.extraLarge)
                    end.linkTo(parent.end, spacing.extraLarge)
                    width = Dimension.fillToConstraints
                }
            ) {
                Text(text = stringResource(id = R.string.login))
            }

            Button(
                onClick = {
                    navController.navigate(ROUTE_REGISTER) {
                        popUpTo(ROUTE_HOME) { inclusive = true }
                    }
                },
                modifier = Modifier.constrainAs(refButtonRegister) {
                    top.linkTo(refButtonLogin.bottom, spacing.large)
                    start.linkTo(parent.start, spacing.extraLarge)
                    end.linkTo(parent.end, spacing.extraLarge)
                    width = Dimension.fillToConstraints
                }
            ) {
                Text(text = stringResource(id = R.string.Register))
            }



            Button(
                onClick = {
                    navController.navigate(ROUTE_ABOUT) {
                        popUpTo(ROUTE_HOME) { inclusive = true }
                    }
                },
                modifier = Modifier.constrainAs(refButtonLogout) {
                    top.linkTo(refButtonRegister.bottom, spacing.large)
                    start.linkTo(parent.start, spacing.extraLarge)
                    end.linkTo(parent.end, spacing.extraLarge)
                    width = Dimension.fillToConstraints
                }
            ) {
                Text(text = stringResource(id = R.string.logout))
            }
            Text(
                modifier = Modifier
                    .constrainAs(refTextAbout) {
                        top.linkTo(refButtonLogout.bottom, spacing.large)
                        start.linkTo(parent.start, spacing.extraLarge)
                        end.linkTo(parent.end, spacing.extraLarge)
                    }
                    .clickable {
                        navController.navigate(ROUTE_ABOUT) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }
                    },
                text = "About PATA",
            )


            homeFlow?.value?.let {
                when (it) {
                    is Resource.Failure -> {
                        val context = LocalContext.current
                        Toast.makeText(context, it.exception.message, Toast.LENGTH_LONG).show()
                    }

                    Resource.Loading -> {
                        CircularProgressIndicator(modifier = Modifier.constrainAs(refLoader) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        })
                    }

                    is Resource.Success -> {
                        LaunchedEffect(Unit) {
                            navController.navigate(ROUTE_LOGIN) {
                                popUpTo(ROUTE_HOME) { inclusive = true }
                            }
                        }
                    }
                }
            }

        }
    }


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    PataTheme {
        HomeScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewDark() {
    PataTheme {
        HomeScreen(null, rememberNavController())
    }
}


