package com.example.restaurantcompose.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val verticalScroll = rememberScrollState()
    var emailIdOrMobile by remember {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(state = verticalScroll),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.group2),
                contentDescription = "Group 2 Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Forgot\nPassword?",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.W600
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Don’t Worry it happens. Please Enter an email  or Mobile associated with your account",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(32.dp))
            LoginInputField(
                text = emailIdOrMobile,
                hint = "Email ID or Mobile",
                icon = R.drawable.work,
                contentDescription = "Email Id Or Mobile Icon",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus(force = true)
                    }
                ),
                isVisualTransformation = false
            ) {
                emailIdOrMobile = it
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Spacer(modifier = Modifier.weight(1f))
        ProceedButton(text = "Submit") {
            navController.navigate(route = Screen.ResetPasswordScreen.route)
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}