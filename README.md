# ansroid-compose-visual-transformation

Some implementations of [VisualTransformation](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/input/VisualTransformation).

## how to use
[![Release](https://jitpack.io/v/Dirtfy/ansroid-compose-visual-transformation.svg)](https://www.jitpack.io/#ansroid-compose-visual-transformation)   

```kotlin
import com.dirtfy.visualtransformation.currency.CurrencyVisualTransformation

@Composable
fun CurrencyInput(modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf("") }

    TextField(
        label = { Text(text = "currency") },
        value = value,
        onValueChange = { value = it },
        modifier = modifier,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        visualTransformation = CurrencyVisualTransformation()
    )

}
```
