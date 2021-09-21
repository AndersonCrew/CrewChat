package com.anderson.crewchat.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharePreferenceUtil @Inject constructor(private val mPref: SharedPreferences) {

    fun putStringExtra(value: String, key: String) {
        mPref.edit().putString(key, value).apply()
    }

    fun putIntExtra(value: Int, key: String) {
        mPref.edit().putInt(key, value).apply()
    }

    fun putFloatExtra(value: Float, key: String) {
        mPref.edit().putFloat(key, value).apply()
    }

    fun getStringExtra(key: String, defaultValue: String): String? {
        return mPref.getString(key, defaultValue)
    }
}