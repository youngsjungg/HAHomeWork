package com.suny.baseinapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions

//internal class MainNavigator(
//    val navController: NavHostController,
//) {
//    private val currentDestination: NavDestination?
//        @Composable get() = navController
//            .currentBackStackEntryAsState().value?.destination
//
//    val startDestination = MainTab.SEARCH.route
//
//    val currentTab: MainTab?
//        @Composable get() = MainTab.find { tab ->
//            currentDestination?.hasRoute(tab::class) == true
//        }
//
//    fun navigate(tab: MainTab) {
//        val navOptions = navOptions {
//            popUpTo(navController.graph.findStartDestination().id) {
//                saveState = true
//            }
//            launchSingleTop = true
//            restoreState = true
//        }
//
//        when (tab) {
//            MainTab
//            MainTab.SEARCH -> navController.navigateSearch(navOptions)
//            MainTab.CHAT -> navController.navigateChat(navOptions)
//            else -> {
//                //setting 모듈은 추후 구성
//            }
////            MainTab.SETTING -> navController.naSe(navOptions)
//        }
//    }
////      추후 클릭 이벤트 추가시 사용
//    fun navigateProductDetail() {
//        navController.navigateProductDetail()
//    }
//
//    private fun popBackStack() {
//        navController.popBackStack()
//    }
//
//    fun popBackStackIfNotHome() {
//        if (!isSameCurrentDestination<MainTabRoute.Home>()) {
//            popBackStack()
//        }
//    }
//    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean {
//        return navController.currentDestination?.hasRoute<T>() == true
//    }
//
//    @Composable
//    fun shouldShowBottomBar() = MainTab.contains {
//        currentDestination?.hasRoute(it::class) == true
//    }
//
//}
//@Composable
//internal fun rememberMainNavigator(
//    navController: NavHostController = rememberNavController(),
//): MainNavigator = remember(navController) {
//    MainNavigator(navController)
//}