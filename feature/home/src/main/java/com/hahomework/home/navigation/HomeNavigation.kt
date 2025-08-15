package com.hahomework.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hahomework.home.component.HomeRoute

fun NavController.navigateHome(navOptions: NavOptions) {
    navigate(HomeRoute.ROUTE, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    padding: PaddingValues,
    onBookDetailClick: (bookId: String) -> Unit,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
) {
    composable(route = HomeRoute.ROUTE) {
        HomeRoute(
            padding,
            onBookDetailClick,
            onShowErrorSnackBar
        )
    }
}

object HomeRoute {
    const val ROUTE = "home"
}