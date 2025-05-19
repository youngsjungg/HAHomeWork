package com.baseinapp.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.exception.ApolloHttpException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel: ViewModel() {



    protected open fun handleNetworkError(throwable: Throwable) {

    }


}