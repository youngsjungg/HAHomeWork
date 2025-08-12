package com.suny.hahomework

import timber.log.Timber

class TimberDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return "${element.className}: #${element.lineNumber}, ${element.methodName}"
    }
}