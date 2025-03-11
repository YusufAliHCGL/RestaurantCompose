package com.example.restaurantcompose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restaurantcompose.R

@Composable
fun RestaurantCard(
    modifier: Modifier = Modifier,
    restaurantImage: Int,
    restaurantName: String
) {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF3F2F2))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(id = restaurantImage),
            contentDescription = "Restaurant Image",
            modifier = Modifier
                .size(110.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = restaurantName,
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.W600,
                    fontSize = 22.sp
                )
            )
            Image(
                painter = painterResource(id = R.drawable.group4),
                contentDescription = "Rating Image",
                modifier = Modifier.size(height = 20.dp, width = 75.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.frame),
                contentDescription = "Recommend Image",
                modifier = Modifier.size(height = 20.dp, width = 85.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.database),
                    contentDescription = "Database Icon",
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "18",
                    style = TextStyle(
                        color = Color(0xFF374151),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400
                    )
                )
            }
        }
    }
}