package com.varsha.assignment3

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varsha.assignment3.ui.theme.Assignment3Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                Loginscreen()


            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Loginscreen() {
    val context = LocalContext.current

    var Username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Your content goes here
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally // changed this line from Alignment.CenterHorizontally to Alignment.CenterHorizontally
        ) {


            Text(
                text = "Login",
                style = TextStyle(fontSize =50.sp) ,
                modifier = Modifier.fillMaxWidth(),
                color=Color.Red,
                textAlign = TextAlign.Center

            )
            OutlinedTextField(
                value = Username,
                label = { Text(text = "Username") },
                onValueChange = { new -> Username = new })
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(value = password,
                label = { Text(text = "Password") },
                onValueChange = { new -> password = new }
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val url1 = "https://www.myntra.com"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url1))
                    try {
                        context.startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(context, "No web browser found", Toast.LENGTH_LONG).show()
                    }
                }
            ) {
                Text(text = "Myntra")
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val url1 = "https://www.amazon.com"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url1))
                    try {
                        context.startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(context, "No web browser found", Toast.LENGTH_LONG).show()
                    }
                }
            ) {
                Text(text = "Amazon")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val url1 = "https://www.flipkart.com"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url1))
                    try {
                        context.startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(context, "No web browser found", Toast.LENGTH_LONG).show()
                    }
                }
            ) {
                Text(text = "Flipkart")
            }

        }


    }
}
