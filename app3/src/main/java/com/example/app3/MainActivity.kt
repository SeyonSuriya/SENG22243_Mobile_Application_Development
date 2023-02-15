package com.example.app3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.app3.ui.theme.Seng22243Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Seng22243Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    EchoDetail()
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EchoDetail() {

    var name by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0,7)))
    }

    var age by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("",TextRange(0,7)))
    }

    var tempName by remember { mutableStateOf("") }
    var tempAge by remember { mutableStateOf("") }

    var clickedEcho: Boolean by remember { mutableStateOf(false) }
    val echologic = EchoLogic()


    //val NAME : MutableLiveData<String> by lazy { MutableLiveData<String>(TextFieldValue("", TextRange(0,7)).toString()) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text("Name")}
            )
            Text("")
            OutlinedTextField(
                value = age,
                onValueChange = {age = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Age")}
            )
            Text("")

            echologic.displayText(name = tempName, age = tempAge, clicked_echo = clickedEcho)

            Text("")
            Button(onClick = {
                clickedEcho = true
                tempName = name.text
                tempAge = age.text
//                Log.d("echoDetail",tempName)
//                Log.d("echoDetail",tempAge)
//                Log.d("echoDetail","echo")

            }) {
                Text(text = "Echo")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Seng22243Theme {
        //Greeting("Android")
        EchoDetail()
    }
}