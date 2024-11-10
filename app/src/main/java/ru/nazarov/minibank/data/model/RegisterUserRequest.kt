package ru.nazarov.minibank.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserRequest(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val username: String,
    val password: String,
    val confirmPassword: String,
)