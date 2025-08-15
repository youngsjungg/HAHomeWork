package com.hahomework.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hahomework.designsystem.component.BookItem
import com.hahomework.designsystem.component.FilterChip
import com.hahomework.designsystem.component.SearchBar
import com.hahomework.designsystem.theme.HaColor
import com.hahomework.designsystem.theme.LocalTypography
import com.hahomework.home.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    onBookDetailClick: (bookId: String) -> Unit,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
        viewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackBar(throwable) }
    }

    HomeScreen(
        padding = padding,
        onBookDetailClick = onBookDetailClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    padding: PaddingValues,
    onBookDetailClick: (bookId: String) -> Unit = {}
) {
    val typography = LocalTypography.current
    var searchText by remember { mutableStateOf("") }
    
    val sampleBooks = remember {
        listOf(
            BookData("1", "도서 제목", "출판사", "저자", "N"),
            BookData("2", "도서 제목", "출판사", "저자", "N"),
            BookData("3", "도서 제목", "출판사", "저자", "N"),
            BookData("4", "도서 제목", "출판사", "저자", "N")
        )
    }
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "검색",
                        style = typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = HaColor.OnSurface
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = HaColor.White
                )
            )
        },
        containerColor = HaColor.White
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    SearchBar(
                        value = searchText,
                        onValueChange = { searchText = it }
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "정확도순",
                            style = typography.contentMedium,
                            color = HaColor.OnSurface
                        )
                        
                        FilterChip(
                            text = "정렬",
                            onClick = { }
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
            
            items(sampleBooks) { book ->
                BookItem(
                    title = book.title,
                    publisher = book.publisher,
                    author = book.author,
                    price = book.price,
                    onItemClick = { onBookDetailClick(book.id) },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}

data class BookData(
    val id: String,
    val title: String,
    val publisher: String,
    val author: String,
    val price: String
)

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        padding = PaddingValues(0.dp)
    )
}
