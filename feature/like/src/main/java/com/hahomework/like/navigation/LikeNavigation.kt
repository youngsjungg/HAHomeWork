package com.hahomework.like.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.hahomework.like.component.LikeRoute

fun NavController.navigateLike(navOptions: NavOptions) {
    navigate(LikeRoute.ROUTE, navOptions)
}

fun NavGraphBuilder.likeNavGraph(
    padding: PaddingValues,
    onBookDetailClick: (bookId: String) -> Unit,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
) {
    composable(route = LikeRoute.ROUTE) {
        LikeRoute(
            padding,
            onBookDetailClick,
            onShowErrorSnackBar
        )
    }
}

object LikeRoute {
    const val ROUTE = "like"
}