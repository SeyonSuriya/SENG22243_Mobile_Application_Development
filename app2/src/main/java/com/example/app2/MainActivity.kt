package com.example.app2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.app2.services.Calculate
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwoGreeting(){
    var number1 by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }

    var number2 by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }

    var total by remember {
        mutableStateOf(0)
    }

    val cal = Calculate()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            OutlinedTextField(
                value = number1,
                onValueChange = {number1 = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Number 1")}
            )
            OutlinedTextField(
                value = number2,
                onValueChange = {number2 = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Number 2")}
            )

            Text("Total is $total")
            Button(onClick = {
                Log.d("TwoGreeting",number1.text)
                Log.d("TwoGreeting",number2.text)
                total = cal.add(number1.text.toInt(), number2.text.toInt())
                Log.d("TwoGreeting","You Clicked!")
            }) {
                Text(text = "Add")
            }
        }

    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name! Welcome")
//}

//@Composable
////try to make this function returns integer value
//fun OutlinedNumberTextField(label: String, _text: TextFieldValue) {
////    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
////        mutableStateOf(TextFieldValue("", TextRange(0, 7))) }
//    var text = _text
//
//
//}

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