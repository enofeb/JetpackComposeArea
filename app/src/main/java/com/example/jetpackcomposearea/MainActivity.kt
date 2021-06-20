package com.example.jetpackcomposearea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
                Greeting(name = "Enes")
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
fun ColumnDemo(nameList: MutableList<String> = mutableListOf("Harry", "Potter")) {
    Column(modifier = Modifier.padding(2.dp)) {
        for (name in nameList){
            Greeting(name = name)
            Divider(color = Color.Blue)
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