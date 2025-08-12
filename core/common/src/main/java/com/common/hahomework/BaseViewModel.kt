package com.common.hahomework

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {



    protected open fun handleNetworkError(throwable: Throwable) {

    }


}