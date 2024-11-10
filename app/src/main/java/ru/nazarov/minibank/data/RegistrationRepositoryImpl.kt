package ru.nazarov.minibank.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nazarov.minibank.data.model.RegisterUserRequest
import ru.nazarov.minibank.data.model.RegisterUserResponse
import ru.nazarov.minibank.domain.RegistrationRepository
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val registrationApi: RegistrationApi,
): RegistrationRepository  {

    override suspend fun registerUser(request: RegisterUserRequest): RegisterUserResponse =
        withContext(Dispatchers.IO) {
            registrationApi.registerUser(request)
        }
}