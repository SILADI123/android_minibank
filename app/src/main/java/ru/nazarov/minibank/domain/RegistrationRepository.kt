package ru.nazarov.minibank.domain

import ru.nazarov.minibank.data.model.RegisterUserRequest
import ru.nazarov.minibank.data.model.RegisterUserResponse

interface RegistrationRepository {

    suspend fun registerUser(request: RegisterUserRequest): RegisterUserResponse
}