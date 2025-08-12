package com.suny.hahomework.navigation

//internal enum class MainTab (
//    val iconResId: Int,
//    internal val contentDescription: String,
//    val route: MainTabRoute,
//) {
//    SEARCH(
//        iconResId = R.drawable.ic_launcher_foreground,
//        contentDescription = "검색",
//        MainTabRoute.Home
//    ),
//    CHAT(
//        iconResId = R.drawable.ic_launcher_foreground,
//        contentDescription = "채팅",
//        MainTabRoute.Chat
//    ),
//    SETTING(
//        iconResId = R.drawable.ic_launcher_foreground,
//        contentDescription = "세팅",
//        MainTabRoute.Setting
//    );
//
//    companion object {
//        @Composable
//        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
//            return MainTab.entries.find { predicate(it.route) }
//        }
//
//        @Composable
//        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
//            return MainTab.entries.map { it.route }.any { predicate(it) }
//        }
//    }
//}