package com.hahomework.like.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable

@Composable
internal fun LikeRoute(
    padding: PaddingValues,
    onBookDetailClick: (bookId: String) -> Unit,
    onShowErrorSnackBar: (throwable: Throwable?) -> Unit,
//    viewModel: LikeViewModel = hiltViewModel(),
) {
//    val sponsorsUiState by viewModel.sponsorsUiState.collectAsStateWithLifecycle()
//
//    LaunchedEffect(true) {
//        viewModel.errorFlow.collectLatest { throwable -> onShowErrorSnackBar(throwable) }
//    }

//    LikeScreen(
//        padding = padding,
//        sponsorsUiState = sponsorsUiState,
//        onSessionClick = onSessionClick,
//        onContributorClick = onContributorClick,
//    )
}

//@Composable
//private fun LikeScreen(
//    padding: PaddingValues,
//    sponsorsUiState: SponsorsUiState,
//    onSessionClick: () -> Unit,
//    onContributorClick: () -> Unit,
//) {
//    val scrollState = rememberScrollState()
//    Column(
//        Modifier
//            .padding(padding)
//            .padding(horizontal = 8.dp)
//            .verticalScroll(scrollState)
//            .padding(bottom = 4.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//    ) {
//        SessionCard(onClick = onSessionClick)
//        ContributorCard(onClick = onContributorClick)
//        SponsorCard(uiState = sponsorsUiState)
//    }
//}
