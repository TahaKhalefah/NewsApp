package com.tahadroid.newsapp.ui.login

import android.text.TextUtils
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class LoginViewModel :ViewModel() {
    val isVisible = ObservableField<Boolean>(true)
    val emailText = ObservableField<String>()
    val passwordText = ObservableField<String>()

    val emailError = ObservableField<String>("")
    val passwordError = ObservableField<String>("")

    fun onLoginClick() {
        if (isValidForm()) {
            Log.w("valid form", "valid form called")
        }
    }

    private fun isValidForm(): Boolean {
        if (TextUtils.isEmpty(emailText.get())) {
            emailError.set("error email")
            return false
        }
        if (TextUtils.isEmpty(passwordText.get())) {
            passwordError.set("error password")
            return false
        }
        return true
    }
}