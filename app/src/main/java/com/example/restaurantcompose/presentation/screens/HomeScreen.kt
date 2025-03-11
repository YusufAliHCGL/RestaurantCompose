package com.example.restaurantcompose.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.restaurantcompose.R
import com.example.restaurantcompose.presentation.components.RestaurantCard
import com.example.restaurantcompose.presentation.components.SearchBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    var searchString by remember {
        mutableStateOf("")
    }
    val letters = remember {
        ('A'..'Z').toList()
    }
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF64FCD9))
                    .padding(vertical = 25.dp, horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "Menu Icon",
                            modifier = Modifier.size(25.dp),
                            tint = Color.Unspecified
                        )
                    }
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.cart),
                            contentDescription = "Cart Icon",
                            modifier = Modifier.size(25.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
                SearchBar(text = searchString, hint = "Search for Shops and Restaurants ") {
                    searchString = it
                }

            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(letters) { letter ->
                RestaurantCard(
                    restaurantImage = R.drawable.restaurant,
                    restaurantName = "$letter Restaurant"
                )
            }
        }
    }

}