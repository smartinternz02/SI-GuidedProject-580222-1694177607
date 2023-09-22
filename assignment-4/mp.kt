package com.varsha.varsaa.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.varsha.varsaa.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MenuPage(navController: NavController) {
    val menuItems = listOf(
        MenuItem("Biriyani", 30.0, R.drawable.biriyani),
        MenuItem("Chicken Kabab", 15.0, R.drawable.kabab),
        MenuItem("Roti", 20.0, R.drawable.roti1),
        MenuItem("Chicken Lolipop", 20.0, R.drawable.lolipop),
    )

    val selectedItems = remember { mutableStateListOf<MenuItem>() }
    var tipAmount by remember { mutableStateOf(0.0) }

    val keyboardController = LocalSoftwareKeyboardController.current
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Menu Selection", style = TextStyle(
                fontSize = 30.sp, // Adjust the fontSize as needed
                color = Color.White, // Set the text color to white
                fontWeight = FontWeight.Bold // Make the text bold
            )
            )
            Spacer(modifier = Modifier.height(16.dp))

            menuItems.forEach { item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Display the item name and price
                    Text(
                        text = "${item.name} - $${item.price}",
                        style = TextStyle(
                            fontSize = 30.sp, // Adjust the fontSize as needed
                            color = Color.White
                        )
                    )

                    // Display the checkbox
                    Checkbox(
                        checked = selectedItems.contains(item),
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Red, // Set the color when the checkbox is checked
                            uncheckedColor = Color.Blue, // Set the color when the checkbox is unchecked
                            checkmarkColor = Color.White // Set the color of the checkmark
                        ),
                        onCheckedChange = { checked ->
                            if (checked) {
                                selectedItems.add(item)
                            } else {
                                selectedItems.remove(item)
                            }
                            // Calculate the total bill when item selection changes
                            tipAmount = calculateTotal(selectedItems)
                        }
                    )

                    // Display the image corresponding to the menu item

                }
                Box(
                    modifier = Modifier
                        .size(100.dp) // Adjust the width as needed
                        .aspectRatio(1f) // Maintain aspect ratio
                ) {
                    // Display the image corresponding to the menu item
                    Column {
                        Image(
                            painter = painterResource(id = item.imageResource),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Total Bill: $${tipAmount + calculateTotal(selectedItems)}",
                style = TextStyle(
                    fontSize = 30.sp, // Adjust the fontSize as needed
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Total bill")
            }
        }
    }
}

    data class MenuItem(val name: String, val price: Double, val imageResource: Int)

    // Function to calculate the total cost of selected items
    fun calculateTotal(selectedItems: List<MenuItem>): Double {
        return selectedItems.sumByDouble { it.price }
    }

