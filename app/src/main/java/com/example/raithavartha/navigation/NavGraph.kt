package com.example.raithavartha.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.raithavartha.ui.screens.CropCategoryScreen
import com.example.raithavartha.ui.screens.ExpertAskScreen
import com.example.raithavartha.ui.screens.HomeScreen
import com.example.raithavartha.ui.screens.SuccessStoriesScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object CropCategory : Screen("crop_category")
    object SuccessStories : Screen("success_stories")
    object ExpertAsk : Screen("expert_ask")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onCropCategoryClick = {
                    navController.navigate(Screen.CropCategory.route)
                },
                onSuccessStoriesClick = {
                    navController.navigate(Screen.SuccessStories.route)
                },
                onExpertAskClick = {
                    navController.navigate(Screen.ExpertAsk.route)
                }
            )
        }
        composable(Screen.CropCategory.route) {
            CropCategoryScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.SuccessStories.route) {
            SuccessStoriesScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.ExpertAsk.route) {
            ExpertAskScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
