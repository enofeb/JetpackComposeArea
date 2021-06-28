package com.example.jetpackcomposearea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class ScaffoldActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun LayoutSlot() {
    Scaffold(topBar = {
        TopAppBar {
            Text(text = "Daily Mirror")
        }
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("Good day in London")
            Text("Have you ever been there?")
        }

    }
}

@Preview
@Composable
fun LayoutPreview() {
    MaterialTheme {
        LayoutSlot()
    }
}