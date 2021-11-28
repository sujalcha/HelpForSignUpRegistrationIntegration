package com.example.helpforsignupregistrationintegration.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helpforsignupregistrationintegration.ui.theme.blue2
import com.example.helpforsignupregistrationintegration.ui.theme.blue4
import com.example.helpforsignupregistrationintegration.ui.theme.white1

@Composable
fun ActivityScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(blue4),
        contentAlignment = Alignment.Center,
    ) {

        Column(
            modifier = Modifier
                .padding(24.dp)
                .background(white1)
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Congratulations!!! You have made it to the Activity Screen")

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(2.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = blue2)
            ) {

                Text(
                    text = "LOG OUT",
                    fontSize = 14.sp,
                    color = white1,
                    modifier = Modifier.padding(0.dp, 20.dp)
                )
                Icon(
                    Icons.Rounded.ArrowForward,
                    contentDescription = "Forward icon",
                    tint = white1,
                    modifier = Modifier.padding(end = 10.dp),
                )

            }
        }


    }

}

@Preview
@Composable
fun defaultprev() {
    ActivityScreen()
}