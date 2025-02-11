package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(title = stringResource(R.string.title),
                                 para1 = stringResource(R.string.para1),
                                 para2 = stringResource(R.string.para2),
                                 modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun GreetingText(title: String, para1: String, para2: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                       .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
        )
        Text(
            text = para1,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = para2,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
        )
    }
}

@Composable
fun GreetingImage(title: String, para1: String, para2: String, modifier: Modifier = Modifier) {
      val image = painterResource(R.drawable.bg_compose_background)
      Column(modifier = modifier.fillMaxSize()) {
          Image(
              painter = image,
              contentDescription = null,
              contentScale = ContentScale.Fit,
              modifier = Modifier
                        .fillMaxWidth(),
              alpha = 0.5F
          )
          GreetingText(title = title,
              para1 = para1,
              para2 = para2,
              modifier = Modifier
                  .fillMaxSize()
                  .padding(8.dp))
      }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        GreetingImage(
            title = stringResource(R.string.title),
            para1 = stringResource(R.string.para1),
            para2 = stringResource(R.string.para2)
        )
    }
}
