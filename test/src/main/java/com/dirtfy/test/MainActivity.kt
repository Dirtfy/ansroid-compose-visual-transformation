package com.dirtfy.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.dirtfy.test.ui.theme.VisualTransformationTheme

import com.dirtfy.visualtransformation.currency.CurrencyVisualTransformation
import com.dirtfy.visualtransformation.phonenumber.PhoneNumberVisualTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisualTransformationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InputColumn(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun InputColumn(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
    ) {
        CurrencyInput()
        PhoneNumberInput()
    }
}

@Composable
fun CurrencyInput(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }

    TextField(
        label = { Text(text = "currency") },
        value = value,
        onValueChange = { value = it },
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        visualTransformation = CurrencyVisualTransformation()
    )

}

@Composable
fun PhoneNumberInput(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }

    TextField(
        label = { Text(text = "phone number") },
        value = value,
        onValueChange = { value = it },
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        visualTransformation = PhoneNumberVisualTransformation()
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VisualTransformationTheme {
        InputColumn()
    }
}