package com.banice.mynotes


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.banice.mynotes.add_edit_mynotes.AddEditMyNotesScreen
import com.banice.mynotes.mynotes_list.MyNotesListScreen
import com.banice.mynotes.ui.theme.MyNotesTheme
import com.banice.mynotes.util.Routes
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.NavType




@AndroidEntryPoint
class MainActivity : ComponentActivity() {
      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNotesTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.MYNOTES_LIST
                ) {
                    composable(Routes.MYNOTES_LIST) {
                        MyNotesListScreen(
                            onNavigate = { navController.navigate(it.route) }
                        )
                    }

                    composable(
                        route = Routes.ADD_EDIT_MYNOTES + "?mynotesId={mynotesId}",
                        arguments = listOf(
                            navArgument(name = "mynotesId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) {
                        AddEditMyNotesScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}








