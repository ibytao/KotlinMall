package com.kotlin.base.widgets

import android.app.Dialog
import android.content.Context
import com.kotlin.base.R

class ProgressLoading(context: Context, themeResId: Int): Dialog(context, themeResId) {
    companion object {
        private lateinit var mDialog: ProgressLoading

        fun create(context: Context) {
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
        }
    }
}