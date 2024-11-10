package ru.nazarov.minibank.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.nazarov.minibank.data.model.RegisterUserRequest

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = hiltViewModel()
) {
    RegistrationContent(
        userState = viewModel.userState,
        updateUserState = { newUserState ->
            viewModel.updateUserState(newUserState)
        },
        createAccount = viewModel::onClickCreateAccountButton
    )
}

@Composable
fun RegistrationContent(
    userState: RegisterUserDomainModel,
    updateUserState: (RegisterUserDomainModel) -> Unit,
    createAccount: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.padding(16.dp)
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
//            var loginText by rememberSaveable { mutableStateOf("") }
//            var passwordText by rememberSaveable { mutableStateOf("") }
//            var againPasswordText by rememberSaveable { mutableStateOf("") }

            Text(
                text = "Регистрация",
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = userState.firstName,
                onValueChange = { newFirstName ->
                    updateUserState(userState.copy(firstName = newFirstName))
                },
                label = {
                    Text("Введите имя")
                },
                singleLine = true,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = userState.lastName,
                onValueChange = { newLastName ->
                    updateUserState(userState.copy(lastName = newLastName))
                },
                label = {
                    Text("Введите фамилию")
                },
                singleLine = true,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = userState.age,
                onValueChange = { newAge ->
                    updateUserState(userState.copy(age = newAge))
                },
                label = {
                    Text("Введите возраст")
                },
                singleLine = true,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = userState.username,
                onValueChange = { newUsername ->
                    updateUserState(userState.copy(username = newUsername))
                },
                label = {
                    Text("Введите логин")
                },
                singleLine = true,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = userState.password,
                onValueChange = { newUserPassword ->
                    updateUserState(userState.copy(password = newUserPassword))
                },
                label = {
                    Text("Введите пароль")
                },
                singleLine = true,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = userState.confirmPassword,
                onValueChange = { newConfirmPassword ->
                    updateUserState(userState.copy(confirmPassword = newConfirmPassword))
                },
                label = {
                    Text("Введите пароль еще раз")
                },
                singleLine = true,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Button(
                onClick = {
                    createAccount()
                },
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 40.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Создать аккаунт"
                )
            }
        }
    }
}

@Preview
@Composable
private fun RegistrationPreview() {
    RegistrationContent(
        userState = RegisterUserDomainModel.defaultState,
        updateUserState = {},
        createAccount = {}
    )
}