package com.hahomework.main.navigation

import com.feature.main.R
import com.hahomework.home.navigation.HomeRoute
import com.hahomework.like.navigation.LikeRoute


internal enum class MainTab(
    val iconResId: Int,
    internal val contentDescription: String,
    val route: String,
) {
    HOME(
        iconResId = R.drawable.ic_search,
        contentDescription = "search",
        route = HomeRoute.ROUTE,
    ),
    LIKE(
        iconResId = R.drawable.ic_heart,
        contentDescription = "like",
        route = LikeRoute.ROUTE
    );

    companion object {

        operator fun contains(route: String): Boolean {
            return entries.map { it.route }.contains(route)
        }

        fun find(route: String): MainTab? {
            return entries.find { it.route == route }
        }
    }
}
