package ru.nazarov.minibank.data

import retrofit2.http.Body
import retrofit2.http.POST
import ru.nazarov.minibank.data.model.RegisterUserRequest
import ru.nazarov.minibank.data.model.RegisterUserResponse

interface RegistrationApi {

    @POST("auth/registration")
    fun registerUser(@Body registerUserRequest: RegisterUserRequest): RegisterUserResponse
}