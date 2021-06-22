package com.example.jetpackcomposearea

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposearea.ui.theme.JetpackComposeAreaTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadScreen {
                HeaderWithImage()
            }
        }
    }
}

@Composable
fun LoadScreen(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(color = Color.White) {
            content()
        }
    }
}

@Composable
fun HeaderWithImage() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        val typography = MaterialTheme.typography

        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "A relax day from Texas. Opportunity dance with " +
                    "sharks and birds really natural adventure for you." +
                    "Let's start the journey",
            style = typography.h6,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Dallas,USA", style = typography.subtitle1
        )
        Text(text = "December 2021", style = typography.body2, color = Color.LightGray)
    }
}

@Preview("Image Activity")
@Composable
fun LoadPreview() {
    LoadScreen {
        HeaderWithImage()
    }
}