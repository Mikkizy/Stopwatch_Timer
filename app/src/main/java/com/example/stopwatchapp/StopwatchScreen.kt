package com.example.stopwatchapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StopWatchScreen(
    OnStartClick: () -> Unit,
    OnPauseClick:() -> Unit,
    OnResetClick: () -> Unit,
    formattedTime: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "STOPWATCH",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = modifier.height(20.dp))
        Text(
            text = formattedTime,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = OnStartClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, backgroundColor = Color.Blue
                )
            ) {
               Text(text = "Start")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = OnPauseClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, backgroundColor = Color.Blue
                )
            ) {
                Text(text = "Pause")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = OnResetClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, backgroundColor = Color.Blue
                )
            ) {
                Text(text = "Reset")
            }
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {

}