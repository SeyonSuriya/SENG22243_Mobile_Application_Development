package com.example.app2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app2.ui.theme.Seng22243Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Seng22243Theme {
                TwoGreeting()
            }
        }
    }
}

@Composable
fun TwoGreeting(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
            Greeting(name = "Seyon")
            Greeting(name = "Master")
            Button(onClick = { Log.d("TwoGreeting","You Clicked!") }) {
                Text(text = "Click Me")
            }
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name! Welcome")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Seng22243Theme {
        // A surface container using the 'background' color from the theme
        TwoGreeting()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview2() {
//    Seng22243Theme (darkTheme = true) {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            Greeting(name = "Seyon")
//        }
//    }
//}