package com.example.restaurantcompose.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaurantcompose.R
import com.example.restaurantcompose.presentation.components.ProceedButton
import com.example.restaurantcompose.presentation.util.Screen

@Composable
fun SignupConfirmScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val verticalScroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(state = verticalScroll),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = painterResource(id = R.drawable.illustration),
            contentDescription = "Illustration Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 20.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.successfully_plane),
                contentDescription = "Successfully Image",
                modifier = Modifier
                    .size(140.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Signed up Successfully",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp
                )
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        ProceedButton(text = "Login") {
            navController.navigate(Screen.HomeScreen.route)
        }


    }

}