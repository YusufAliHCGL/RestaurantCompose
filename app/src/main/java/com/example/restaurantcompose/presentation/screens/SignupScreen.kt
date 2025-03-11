package com.example.restaurantcompose.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaurantcompose.R
import com.example.restaurantcompose.presentation.util.Screen
import com.example.restaurantcompose.presentation.components.LoginInputField
import com.example.restaurantcompose.presentation.components.ProceedButton

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val email = remember {
        mutableStateOf("")
    }
    val fullName = remember {
        mutableStateOf("")
    }
    val mobile = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current
    val verticalScroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(state = verticalScroll),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.illustration),
            contentDescription = "Illustration Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Sign up",
            style = TextStyle(
                fontSize = 34.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Start
        )
        LoginInputField(
            text = email.value,
            hint = "E-mail",
            icon = R.drawable.work,
            contentDescription = "E-mail Icon",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(focusDirection = FocusDirection.Next)
                }
            ),
            isVisualTransformation = false
        ) {
            email.value = it
        }
        LoginInputField(
            text = fullName.value,
            hint = "Full name",
            icon = R.drawable.profile,
            contentDescription = "Full name Icon",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(focusDirection = FocusDirection.Next)
                }
            ),
            isVisualTransformation = false
        ) {
            fullName.value = it
        }
        LoginInputField(
            text = mobile.value,
            hint = "Mobile",
            icon = R.drawable.calling,
            contentDescription = "Mobile Icon",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(focusDirection = FocusDirection.Next)
                }
            ),
            isVisualTransformation = false
        ) {
            mobile.value = it
        }
        LoginInputField(
            text = password.value,
            hint = "Password",
            icon = R.drawable.password,
            contentDescription = "Password Icon",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus(force = true)
                }
            ),
            isVisualTransformation = true
        ) {
            password.value = it
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = buildAnnotatedString {
                append("By Signing up, you’re agree to our ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue
                    )
                ) {
                    append("Term & Conditions")
                }
                append(" and ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue
                    )
                ) {
                    append("Privacy Policy")
                }
            },
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 14.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProceedButton(text = "Continue") {
            navController.navigate(route = Screen.SignupConfirmScreen.route)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Joined Before? ",
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                text = "Login",
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .clickable {
                        navController.navigate(route = Screen.LoginScreen.route)
                    }
                    .padding(horizontal = 2.dp)
            )
        }
    }
}