package com.example.app3

import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class EchoLogic {

    @Composable
    fun displayText(name: String, age: String, clicked_echo: Boolean) {
        //echo the name and age only if both details are provided
        if (name.isNotEmpty() && age.isNotEmpty()) {
            Text(
                text = "Hello, $name!, you are $age years old.",
                style = typography.headlineSmall
            )
        } else if (name.isNotEmpty() && clicked_echo) {
            Text(
                text = "Please enter your age.",
                style = typography.bodyMedium
            )
        } else if (age.isNotEmpty() && clicked_echo) {
            Text(
                text = "Please enter your name.",
                style = typography.bodyMedium
            )
        } else if (name.isEmpty() && age.isEmpty() && clicked_echo) {
            Text(
                text = "Please enter you details.",
                style = typography.bodyMedium
            )
        }
    }
}