package com.example.petproject.repo

import android.content.Context
import android.content.SharedPreferences
import com.example.petproject.utils.EMPTY_STRING

class PrefRepository(val context: Context) : PrefService {

    private val preferences: SharedPreferences? = null
    private val KEY_TOKENS = "TOKENS"
    private val KEY_ACCESS_TOKEN = "ACCESS_TOKEN"
    private val KEY_REFRESH_TOKEN = "REFRESH_TOKEN"

    private fun getPreference(context: Context): SharedPreferences {
        return if (preferences === null)
            context.getSharedPreferences(KEY_TOKENS, Context.MODE_PRIVATE)
        else preferences
    }

    private val editor = getPreference(context).edit()

    override fun saveTokens(accessToken: String, refreshToken: String) {
        editor.putString(KEY_ACCESS_TOKEN, accessToken).apply()
        editor.putString(KEY_REFRESH_TOKEN, refreshToken).apply()
    }

    override fun getAccessToken() = getPreference(context).getString(KEY_ACCESS_TOKEN, EMPTY_STRING)!!
}
