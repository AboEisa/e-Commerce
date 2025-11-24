package com.example.e_commerce.utils

import android.util.Patterns
import kotlin.text.isNotEmpty



fun isValidEmail(email: String): Boolean {
    return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}


