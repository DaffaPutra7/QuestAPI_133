package com.example.pam_pertemuan11.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pam_pertemuan11.ui.view.DestinasiDetail
import com.example.pam_pertemuan11.ui.view.DestinasiEntry
import com.example.pam_pertemuan11.ui.view.DestinasiHome
import com.example.pam_pertemuan11.ui.view.DetailView
import com.example.pam_pertemuan11.ui.view.EntryMhsScreen
import com.example.pam_pertemuan11.ui.view.HomeScreen
import com.example.pam_pertemuan11.ui.view.UpdateView

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {

        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {navController.navigate(DestinasiEntry.route)},
                onDetailClick = { nim ->
                    navController.navigate("${DestinasiDetail.route}/$nim")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntryMhsScreen(navigateBack = {
                navController.navigate(DestinasiHome.route) {
                    popUpTo(DestinasiHome.route) {
                        inclusive = true
                    }
                }
            })
        }

        composable(
            route = "${DestinasiDetail.route}/{nim}",
            arguments = listOf(navArgument("nim") { type = NavType.StringType })
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: return@composable
            DetailView(
                nim = nim,
                navigateBack = {
                    navController.navigateUp()
                },
                navController = navController
            )
        }

        composable(
            route = "update_mhs/{nim}",
            arguments = listOf(navArgument("nim") { type = NavType.StringType })
        ) { backStackEntry ->
            val nim = backStackEntry.arguments?.getString("nim") ?: return@composable
            UpdateView(
                nim = nim,
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}