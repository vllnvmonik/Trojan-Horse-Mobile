package com.hackathon.trojan_horse_mobile.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hackathon.trojan_horse_mobile.R
import com.hackathon.trojan_horse_mobile.components.ClickableNavigationText
import com.hackathon.trojan_horse_mobile.components.EditText
import com.hackathon.trojan_horse_mobile.components.EditTextPassword
import com.hackathon.trojan_horse_mobile.components.LogoImage
import com.hackathon.trojan_horse_mobile.components.RoundedButton
import com.hackathon.trojan_horse_mobile.components.TitleText
import com.hackathon.trojan_horse_mobile.navigation.Screen
import com.hackathon.trojan_horse_mobile.uistate.SignInState
import com.hackathon.trojan_horse_mobile.viewmodel.SignInViewModel

@Composable
fun SignInScreen(navController: NavHostController, viewModel: SignInViewModel) {
    val uiState by viewModel.uiState.collectAsState()


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.background_color)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            LogoImage()
            Spacer(modifier = Modifier.height(20.dp))
            TitleText(text = stringResource(R.string.hey_there))
            Spacer(modifier = Modifier.height(40.dp))

            EditText(
                value = uiState.email,
                onValueChange = viewModel::onEmailChanged,
                title = "Email",
                keyboardType = KeyboardType.Text,
                errorMessage = "Must be a valid email address"
            )

            Spacer(modifier = Modifier.height(5.dp))

            EditTextPassword(
                value = uiState.password,
                onValueChange = viewModel::onPasswordChanged,
                title = "Password",
                isError = false,
            )

            Spacer(modifier = Modifier.height(10.dp))


            Spacer(modifier = Modifier.height(50.dp))

            RoundedButton(
                text = stringResource(R.string.sign_in),
                onClick = {
                    if (uiState.isFormValid) {
//                        viewModel.signIn()
                        navController.navigate(Screen.AppRoute.route)
                    } else {

//                        showErrorDialog = true
                    }
                },
                enabled = true,
//                validation = {uiState.isFormValid},
//                errorText = "Please fill in all required fields"

            )

            Spacer(modifier = Modifier.height(120.dp))

            ClickableNavigationText(
                normalText = "Don't have an account?",
                clickableText = "SIGN UP!",
                navigateTo =  Screen.SignUpScreen.route,
                navController = navController
            )
        }

    }
}

//@Preview
//@Composable
//fun SignInPrev() {
//    SignInScreen(navController = rememberNavController())
//}