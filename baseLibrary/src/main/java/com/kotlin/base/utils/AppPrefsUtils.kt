package com.kotlin.base.utils

import android.content.Context
import android.content.SharedPreferences
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.common.BaseConstant

object AppPrefsUtils {
    private var sp: SharedPreferences = BaseApplication.context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
    private var ed: SharedPreferences.Editor

    init {
        ed = sp.edit()
    }


    fun putBoolean(key: String, value: Boolean) {
        ed.putBoolean(key, value)
        ed.commit()
    }

    fun getBoolean(key: String): Boolean{
        return sp.getBoolean(key, false)
    }

    fun putString(key: String, value: String) {
        ed.putString(key, value)
        ed.commit()
    }

    fun getString(key: String): String? {
        return sp.getString(key, "")
    }

    fun putInt(key: String, value: Int) {
        ed.putInt(key, value)
        ed.commit()
    }

    fun getInt(key: String): Int {
        return sp.getInt(key, 0)
    }

    fun putLong(key: String, value: Long) {
        ed.putLong(key, value)
        ed.commit()
    }

    fun getLong(key: String): Long {
        return sp.getLong(key, 0)
    }

    fun putStringSet(key: String, set: Set<String>) {
        ed.putStringSet(key, set)
        ed.commit()
    }

    fun getStringSet(key: String): Set<String> {
        val set = setOf<String>()
        return sp.getStringSet(key, set) as Set<String>
    }

    fun remove(key: String) {
        ed.remove(key)
        ed.commit()
    }
}