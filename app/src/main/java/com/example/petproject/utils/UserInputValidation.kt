package com.example.petproject.utils

fun isEmptyField(text: String) = text.isEmpty()

fun isEmailValid(email: String): Boolean {
    val localPart = "^[\\w-.]+"
    val domainPart = "[\\w-.]{2,}[^.]?"
    val rootDomain = "\\.[\\w-]{2,}"
    val validEmailRegex = "$localPart@$domainPart$rootDomain"
    return email.matches(Regex(validEmailRegex))
}

fun isPasswordMatch(password: String, passConfirm: String) = password == passConfirm
