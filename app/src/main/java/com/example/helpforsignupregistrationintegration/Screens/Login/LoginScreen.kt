package com.example.helpforsignupregistrationintegration.Screens.Login

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.helpforsignupregistrationintegration.Screens.Registrations.RegistrationsScreen
import com.example.helpforsignupregistrationintegration.ui.theme.*

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen() {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val state = rememberScrollState()

    val crossforemail = remember { mutableStateOf(false) }
    crossforemail.value = email.value.isNullOrEmpty()

    var passwordVisibility by remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

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
                .padding(24.dp)
                .verticalScroll(state),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = "LOG IN",
                color = blue1,
                fontSize = 20.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(20.dp, 20.dp)
            )

            // textfield for email
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = blue4,
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                leadingIcon = {

                    Icon(
                        Icons.Rounded.Email,
                        modifier = Modifier.padding(22.dp),
                        contentDescription = "Icon Email",
                        tint = blue2
                    )


                },
                placeholder = {
                    Text(
                        text = "Email",
                        fontSize = 16.sp,
                        color = blue3
                    )
                },
                trailingIcon = {
                    if (!crossforemail.value) {
                        Icon(
                            Icons.Rounded.Clear,
                            contentDescription = "Icon Clear",
                            tint = blue2,
                            modifier = Modifier
                                .clickable(onClick = {
                                    email.value = ""
                                    crossforemail.value = false
                                })
                                .padding(22.dp)
                        )
                    }

                },
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }),
                modifier = Modifier.border(1.dp, blue3, RectangleShape)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // textfield for password
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = blue4,
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Lock,
                        contentDescription = "Icon Lock",
                        tint = blue2,
                        modifier = Modifier.padding(22.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = "Password",
                        fontSize = 16.sp,
                        color = blue3,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                },
                trailingIcon = {
                    Icon(
                        Icons.Rounded.Clear,
                        contentDescription = "Icon Clear",
                        tint = blue2,
                        modifier = Modifier
                            .clickable(onClick = {
                                !passwordVisibility
                            })
                            .padding(22.dp)
                    )
                },
                shape = RoundedCornerShape(8.dp),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }),
                modifier = Modifier.border(1.dp, blue3, RectangleShape)
            )

            Spacer(modifier = Modifier.height(20.dp))


            Button(
                onClick = {
                    //   viewModel.signInWithEmailAndPassword(email.value.trim(), password.value.trim())
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(2.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = blue2)
            ) {

                Text(
                    text = "LOG IN",
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
            Spacer(modifier = Modifier.height(20.dp))


            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Forgot Password?", color = blue1)
            }


            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "New to this?",
                    color = grey1,
                    fontSize = 12.sp
                )

                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "SIGN UP", color = blue1)
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen()
}