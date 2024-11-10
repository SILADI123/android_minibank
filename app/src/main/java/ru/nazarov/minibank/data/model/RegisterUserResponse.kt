package ru.nazarov.minibank.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserResponse(
    @SerialName("jwt-token")
    val token: String,
    val message: String,
)
