package com.KursachApp.util

import android.content.Context

object ContextHelper {

    fun prependPackageName(context: Context, value: String): String {
        return context.packageName + value
    }
}