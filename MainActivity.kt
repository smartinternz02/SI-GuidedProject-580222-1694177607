 package com.varsha.a2ndactivity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.varsha.a2ndactivity.ui.theme._2ndActivityTheme
import java.util.Random

 class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
         var resultView : TextView
         var rollButton: Button
         val image: ImageView

         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         resultView=findViewById(R.id.resultView)
         image=findViewById(R.id.image)
         rollButton=findViewById(R.id.rollButton)
         rollButton.setOnClickListener{
             rollDice(resultView)
         }

     }
     fun rollDice(resultView:TextView){
         val random= Random()
         val randomNumber=random.nextInt(6)+1

         val resultText="You roller a $randomNumber"
         resultView.text=resultText
         when(randomNumber){
             1->:
             image
         }

     }

 }

