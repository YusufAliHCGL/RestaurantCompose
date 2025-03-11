package com.example.restaurantcompose.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaurantcompose.presentation.components.ProceedButton
import com.example.restaurantcompose.presentation.util.Screen

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val verticalScroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(state = verticalScroll),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "You are a",
            style = TextStyle(
                color = Color.Black,
                fontSize = 40.sp,
                fontWeight = FontWeight.W600
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(16.dp))
        ProceedButton(text = "Restaurant") {
            navController.navigate(Screen.SignupScreen.route)
        }
        Spacer(modifier = Modifier.height(12.dp))
        ProceedButton(text = "Customer") {
            navController.navigate(Screen.SignupScreen.route)
        }

    }


}