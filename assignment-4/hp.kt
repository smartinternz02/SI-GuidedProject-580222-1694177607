package com.varsha.varsaa

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
    fun HotelSelectionPage(navController: NavController) {
        val hotels = listOf("Taj Hotel", "Supreme Hotel", "Prabha grand inn")
        var selectedHotel by remember { mutableStateOf<String?>(null) }
        Box(
            modifier = Modifier
                .fillMaxSize() // Fill the entire screen

        ) {
            Image(
                painter = painterResource(id = R.drawable.info), // Replace with your image resource
                contentDescription = null, // Provide a content description if needed
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(text = "Select a Hotel", style = TextStyle(
                    fontSize = 30.sp, // Adjust the fontSize as needed
                    color = Color.White, // Set the text color to white
                    fontWeight = FontWeight.Bold // Make the text bold
                )
                )
                Spacer(modifier = Modifier.height(16.dp))

                hotels.forEach { hotel ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedHotel = hotel
                                navController.navigate("menu")
                            }
                            .padding(8.dp)
                    ) {
                        Text(text = hotel, style = TextStyle(
                            fontSize = 30.sp, // Adjust the fontSize as needed
                            color = Color.White )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        // Implement logic for going back to login page if necessary
                        navController.popBackStack()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Back to Login")
                }
            }
        }
    }
