package com.example.jetpackcomposearea

import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposearea.ui.theme.JetpackComposeAreaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                ColumnDemo()
            }
        }
    }
}

//My app content
@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetpackComposeAreaTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

//Single text
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(12.dp))
}

//Column similar with linearlayout
@Composable
fun ColumnDemo(nameList: MutableList<String> = MutableList(1000) { "Android #$it" }) {

    val countState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(names = nameList, Modifier.weight(1f))
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter(
            count = countState.value,
            updateCount = { newValue ->
                countState.value = newValue
            }
        )
    }
}

//Button
@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {

    Button(
        onClick = { updateCount(count + 1) },
        colors = ButtonDefaults.buttonColors(backgroundColor = if (count > 5) Color.Magenta else Color.Blue)
    ) {
        Text("I've been clicked $count times")
    }
}

//Lazy column=Recyclerview
@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(names) { name ->
            Greeting(name = name)
            Divider(color = Color.Black)
        }
    }
}

//Preview
@Preview("Text preview")
@Composable
fun DefaultPreview() {
    MyApp {
        ColumnDemo()
    }
}