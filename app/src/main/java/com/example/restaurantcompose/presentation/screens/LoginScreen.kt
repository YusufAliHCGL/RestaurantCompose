package com.example.restaurantcompose.presentation.screens

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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaurantcompose.R
import com.example.restaurantcompose.presentation.util.Screen
import com.example.restaurantcompose.presentation.components.LoginInputField
import com.example.restaurantcompose.presentation.components.ProceedButton
import com.example.restaurantcompose.presentation.components.ThirdPartyLoginButton

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val verticalScroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(state = verticalScroll),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var emailOrMobile by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        val focusManager = LocalFocusManager.current
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.group1),
            contentDescription = "Group 1 Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Login",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.W600,
                fontSize = 40.sp
            ),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(16.dp))
        LoginInputField(
            text = emailOrMobile,
            hint = "Email ID or Mobile",
            icon = R.drawable.calling,
            contentDescription = "Email ID or Mobile Icon",
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
            emailOrMobile = it
        }
        Spacer(modifier = Modifier.height(8.dp))
        LoginInputField(
            text = password,
            hint = "Password",
            icon = R.drawable.password,
            contentDescription = "Password Image",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(focusDirection = FocusDirection.Next)
                }
            ),
            isVisualTransformation = true
        ) {
            password = it
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Forgot Password?",
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.W400,
                fontSize = 14.sp
            ),
            modifier = Modifier
                .align(Alignment.End)
                .clickable {
                    navController.navigate(route = Screen.ForgotPasswordScreen.route)
                }
                .padding(6.dp),
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProceedButton(text = "Continue") {
            navController.navigate(Screen.HomeScreen.route)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp),
                thickness = 1.dp,
                color = Color(0xFFF3F2F2)
            )
            Text(
                text = "OR",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400
                )
            )
            HorizontalDivider(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp),
                thickness = 1.dp,
                color = Color(0xFFF3F2F2)
            )
        }
        ThirdPartyLoginButton(
            text = "Login with Google",
            icon = R.drawable.google,
            contentDescription = "Google Icon"
        ) {

        }
        Spacer(modifier = Modifier.height(2.dp))
        ThirdPartyLoginButton(
            text = "Login with Facebook",
            icon = R.drawable.facebook,
            contentDescription = "Facebook Icon"
        ) {

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "New to us? ",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp
                )
            )
            Text(
                text = "Register",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                ),
                modifier = Modifier
                    .clickable {
                        navController.navigate(route = Screen.SignupScreen.route)
                    }.padding(2.dp)
            )
        }

    }
}