package com.banice.keeptrack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.navDeepLink
import com.banice.keeptrack.more.MoreScreen
import com.banice.keeptrack.ui.theme.KeepTrackTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


val bottomMenuList = listOf(
    Screen.ExpenseList,
    Screen.More
)

@ExperimentalComposeUiApi
@ExperimentalAnimationApi

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    MainScreen(navController)
                }
            }
        }
    }
}


@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalSerializationApi
@Composable
fun MainScreen(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current as ComponentActivity
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            val route = navBackStackEntry?.destination?.route ?: ""
            if (route == Screen.ExpenseAdd.route) {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = route.toToolbarLabelResId()))
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }) {
                            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
                        }
                    }
                )
            } else {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = route.toToolbarLabelResId()))
                    },
                )
            }
        },
        bottomBar = {
            BottomNavigation {
                val currentDestination = navBackStackEntry?.destination
                bottomMenuList.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(text = stringResource(id = screen.labelResourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.ExpenseList.route,
            Modifier.padding(innerPadding)
        ) {
            // Expense List
            composable(
                route = Screen.ExpenseList.route,
                deepLinks = listOf(navDeepLink {
                    uriPattern = "$DEEPLINK_BASE_URI/$DEEPLINK_SUFFIX_EXPENSE_LIST"
                })
            ) {
                ExpenseListScreen(navController = navController)
            }

            // Expense detail dialog
            dialog(
                route = Screen.ExpenseDetailDialog.route + "/{expenseWithCategory}",
            ) {
                it.arguments?.getString("expenseWithCategory")
                    ?.also { jsonStr ->
                        ExpenseDetailDialog(
                            navController = navController,
                            expenseWithCategory = Json.decodeFromString(jsonStr)
                        )
                    }
            }

            // Expense detail
            composable(
                route = Screen.ExpenseDetail.route + "/{expenseId}",
                deepLinks = listOf(navDeepLink {
                    uriPattern = "$DEEPLINK_BASE_URI/$DEEPLINK_SUFFIX_EXPENSE_DETAIL/{expenseId}"
                })
            ) {
                ExpenseDetailScreen()
            }
            composable(
                route = Screen.ExpenseAdd.route,
                deepLinks = listOf(navDeepLink {
                    uriPattern = "$DEEPLINK_BASE_URI/$DEEPLINK_SUFFIX_EXPENSE_ADD"
                })
            ) {
                ExpenseAddScreen(navController = navController,
                    onShowSnackBar = {
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = context.getString(it),
                                duration = SnackbarDuration.Short
                            )
                        }
                    })
            }
            composable(
                route = Screen.Chart.route,
            ) {
                ChartScreen()
            }
            composable(
                route = Screen.More.route,
                deepLinks = listOf(navDeepLink {
                    uriPattern = "$DEEPLINK_BASE_URI/$DEEPLINK_SUFFIX_MORE"
                })
            ) {
                MoreScreen(navController = navController)
            }
        }
    }
}