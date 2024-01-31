package com.myfirstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myfirstcompose.ui.theme.MyFirstComposeTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //flksflsdflk
            MyFirstComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.secondary
                ) {
                    // Create an instance of MessageCard and pass it to the composable
                    MessageList(generateSampleMessages())

                }
            }
        }
    }

    private fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
    ): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }

    private fun doIt() {
        val items = listOf(1, 2, 3, 4, 5)
        val concatenatedString: String = listOf(
            "Hello",
            ", ",
            "fucking",
            ", ",
            "world",
            "!"
        ).fold("") { acc, nextElement -> acc + nextElement }
        // Output: Concatenated String: Hello, world!
        println("Concatenated String: " + "$concatenatedString")

// Lambdas are code blocks enclosed in curly braces.
        items.fold("0") {
            // When a lambda has parameters, they go first, followed by '->'
                acc: String, i: Int ->
            print("acc = $acc, i = $i, ")
            val result = acc + i
            println("result = $result")
            // The last expression in a lambda is considered the return value:
            result
        }


// Parameter types in a lambda are optional if they can be inferred:
        val joinedToString = items.fold("Elements:") { acc, i -> "$acc $i" }

// Function references can also be used for higher-order function calls:
        val product = items.fold(1, Int::times)

        println("joinedToString = $joinedToString")
        println("product = $product")

        val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }

        // Create a function type with two parameters and assign it the value of repeatFun
        // val twoParameters: (String, Int) -> String = repeatFun // OK

        // Define a function that takes a function as a parameter and applies it to "hello" and 3
        fun runTransformation(f: (String, Int) -> String): String {
            return f("hello", 3)
        }

        // Call runTransformation with repeatFun as an argument
        val result = runTransformation(repeatFun) // OK

        println("result = $result")

        Timber.d("Debug message");
        Timber.e("Error message");
        Timber.i("Info message");

    }

    override fun onResume() {
        super.onResume()
        doIt()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

@Composable
fun MessageList(messages: List<MessageCard>) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(messages) { message ->
            MessageCard(msg = message)
            Divider(modifier = Modifier.height(2.dp)) // Add a divider between items if needed

        }
    }
}

@Composable
fun MessageCard(msg: MessageCard) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.person),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MessageListPreview() {
    MessageList(generateSampleMessages())
}

fun generateSampleMessages(): List<MessageCard> {
    return listOf(
        MessageCard("John Doe", "This is the message body 1"),
        MessageCard("Jane Doe", "This is the message body 2"),
        MessageCard("Bob Smith", "This is the message body 3"),
        MessageCard("John Doe", "This is the message body 1"),
        MessageCard("Jane Doe", "This is the message body 2"),
        MessageCard("Bob Smith", "This is the message body 3"),
        MessageCard("John Doe", "This is the message body 1"),
        MessageCard("Jane Doe", "This is the message body 2"),
        MessageCard("Bob Smith", "This is the message body 3"),
        MessageCard("John Doe", "This is the message body 1"),
        MessageCard("Jane Doe", "This is the message body 2"),
        MessageCard("Bob Smith", "This is the message body 3"),
        MessageCard("John Doe", "This is the message body 1"),
        MessageCard("Jane Doe", "This is the message body 2"),
        MessageCard("Bob Smith", "This is the message body 3"),
        MessageCard("John Doe", "This is the message body 1"),
        MessageCard("Jane Doe", "This is the message body 2"),
        MessageCard("Bob Smith", "This is the message body 3"),
        MessageCard("John Doe", "This is the message body 1"),
        MessageCard("Jane Doe", "This is the message body 2"),
        MessageCard("Bob Smith", "This is the message body 3"),
        MessageCard("John Doe", "This is the message body 1"),
        MessageCard("Jane Doe", "This is the message body 2"),
        MessageCard("Bob Smith", "This is the message body 3")
    )
}

data class MessageCard(val author: String, val body: String)
