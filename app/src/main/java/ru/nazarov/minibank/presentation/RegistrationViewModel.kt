package ru.nazarov.minibank.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.nazarov.minibank.data.model.RegisterUserRequest
import ru.nazarov.minibank.domain.RegistrationRepository
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registrationRepository: RegistrationRepository,
) : ViewModel() {

    var userState by mutableStateOf(RegisterUserDomainModel.defaultState)
        private set

    fun updateUserState(newUserData: RegisterUserDomainModel) {
        userState = newUserData
    }

    fun onClickCreateAccountButton() {
        viewModelScope.launch {
            registrationRepository.registerUser(
                RegisterUserDomainModel.toRequestModel(userState)
            )
        }
    }
}

data class RegisterUserDomainModel(
    val firstName: String,
    val lastName: String,
    val age: String,
    val username: String,
    val password: String,
    val confirmPassword: String
) {
    companion object {
        val defaultState: RegisterUserDomainModel = RegisterUserDomainModel(
            firstName = "",
            lastName = "",
            age = "",
            username = "",
            password = "",
            confirmPassword = ""
        )

        fun toRequestModel(domainModel: RegisterUserDomainModel): RegisterUserRequest =
            RegisterUserRequest(
                firstName = domainModel.firstName,
                lastName = domainModel.lastName,
                age = domainModel.age.toIntOrNull() ?: 0,
                username = domainModel.username,
                password = domainModel.password,
                confirmPassword = domainModel.confirmPassword
            )
    }
}