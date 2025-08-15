package com.hahomework.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hahomework.main.component.MainScreen
import com.hahomework.main.navigation.MainNavigator
import com.hahomework.main.navigation.rememberMainNavigator
import com.hahomework.navigation.NavigationConstants.KEY_BOOK_ID
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val bookIdFromWidget: MutableStateFlow<String?> = MutableStateFlow(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent.getStringExtra(KEY_BOOK_ID)?.let {
            bookIdFromWidget.value = it
            intent.removeExtra(KEY_BOOK_ID)
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            val navigator: MainNavigator = rememberMainNavigator()
            val bookId = bookIdFromWidget.collectAsStateWithLifecycle().value

//            LaunchedEffect(bookId) {
//                bookId?.let {
//                    navigator.(it)
//                }
//            }
            MainScreen(
                navigator = navigator,
            )
        }
    }
}
