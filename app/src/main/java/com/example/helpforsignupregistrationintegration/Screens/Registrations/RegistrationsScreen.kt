package com.example.helpforsignupregistrationintegration.Screens.Registrations

import android.util.Log
import android.view.View
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helpforsignupregistrationintegration.R
import com.example.helpforsignupregistrationintegration.ui.theme.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.lifecycle.ViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegistrationsScreen(viewmodel :ViewModelRegistrastionScreen) {

    var fullname by remember { viewmodel.fullname }
    var email by remember { viewmodel.email }
    var mobilenumber by remember { viewmodel.mobilenumber }
    var password by remember { viewmodel.password }
    var confirmpassword by remember { viewmodel.confirmpassword }
    var checkbox by remember { viewmodel.checkbox }

    var crossforfullname by remember { viewmodel.crossforfullname }
    var crossforemail by remember { viewmodel.crossforemail }
    var crossformobilenumber by remember { viewmodel.crossformobilenumber }
    var crossforpassword by remember { viewmodel.crossforpassword }
    var crossforconfirmpassword by remember { viewmodel.crossforconfirmpassword }

    var errorfullname by remember { viewmodel.errorfullname }
    var erroremail by remember { viewmodel.erroremail }
    var errormobilenumber by remember { viewmodel.errormobilenumber }

    var errorpassword1 by remember { viewmodel.errorpassword1 }
    var errorpassword2 by remember { viewmodel.errorpassword2 }
    var errorpassword3 by remember { viewmodel.errorpassword3 }
    var errorpassword4 by remember { viewmodel.errorpassword4 }
    var errorpassword5 by remember { viewmodel.errorpassword5 }
    var errorpassword6 by remember { viewmodel.errorpassword6 }

    var errorconfirmpassword by remember { viewmodel.errorconfirmpassword }
    var errorcheckbox by remember { viewmodel.errorcheckbox }

    val state = rememberScrollState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    crossforfullname= fullname.isNullOrEmpty()
    crossforemail = email.isNullOrEmpty()
    crossformobilenumber = mobilenumber.isNullOrEmpty()
    crossforpassword = password.isNullOrEmpty()
    crossforconfirmpassword = confirmpassword.isNullOrEmpty()

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
                text = "CREATE ACCOUNT",
                color = blue1,
                fontSize = 20.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(20.dp, 20.dp)
            )

            // textfield for name
            TextField(
                value = fullname,
                onValueChange = { fullname = it },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = blue4,
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = blue2
                ),
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Person,
                        contentDescription = "Icon person",
                        tint = blue2,
                        modifier = Modifier.padding(22.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = "Full Name",
                        fontSize = 16.sp,
                        color = blue3,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                },
                trailingIcon = {
                    if (!crossforfullname) {
                        Icon(
                            Icons.Rounded.Clear,
                            contentDescription = "Icon Clear",
                            tint = blue2,
                            modifier = Modifier
                                .clickable(onClick = {
                                    fullname = ""
                                    crossforfullname = false
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
                modifier = Modifier
                    .border(1.dp, blue3, RectangleShape)
                    .fillMaxWidth()
            )


            if(!errorfullname.isNullOrEmpty()){
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = errorfullname,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // textfield for email
            TextField(
                value = email,
                onValueChange = { email = it },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = blue4,
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = blue2
                ),
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Email,
                        contentDescription = "Icon Email",
                        tint = blue2,
                        modifier = Modifier.padding(22.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = "Email",
                        fontSize = 16.sp,
                        color = blue3,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                },
                trailingIcon = {
                    if (!crossforemail) {
                        Icon(
                            Icons.Rounded.Clear,
                            contentDescription = "Icon Clear",
                            tint = blue2,
                            modifier = Modifier
                                .clickable(onClick = {
                                    email = ""
                                    crossforemail = false
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
                modifier = Modifier
                    .border(1.dp, blue3, RectangleShape)
                    .fillMaxWidth()
            )
            if(!erroremail.isNullOrEmpty()){
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = erroremail,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // textfield for number
            TextField(
                value = mobilenumber,
                onValueChange = { mobilenumber = it },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = blue4,
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = blue2
                ),
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Phone,
                        contentDescription = "Icon Phone",
                        tint = blue2,
                        modifier = Modifier.padding(22.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = "Phone number",
                        fontSize = 16.sp,
                        color = blue3,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                },
                trailingIcon = {
                    if (!crossformobilenumber) {
                        Icon(
                            Icons.Rounded.Clear,
                            contentDescription = "Icon Clear",
                            tint = blue2,
                            modifier = Modifier
                                .clickable(onClick = {
                                    mobilenumber = ""
                                    crossformobilenumber = false
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
                modifier = Modifier
                    .border(1.dp, blue3, RectangleShape)
                    .fillMaxWidth()
            )

            if(!errormobilenumber.isNullOrEmpty()){
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = errormobilenumber,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // textfield for password
            TextField(
                value = password,
                onValueChange = { password= it },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = blue4,
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = blue2
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
                    if (!crossforpassword) {
                        Icon(
                            Icons.Rounded.Clear,
                            contentDescription = "Icon Clear",
                            tint = blue2,
                            modifier = Modifier
                                .clickable(onClick = {
                                    password= ""
                                    crossforpassword = false
                                })
                                .padding(22.dp)
                        )
                    }
                },
                shape = RoundedCornerShape(8.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }),
                modifier = Modifier
                    .border(1.dp, blue3, RectangleShape)
                    .fillMaxWidth()
            )

            if(!errorpassword1.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = errorpassword1,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }
            if(!errorpassword2.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = errorpassword2,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }

            if(!errorpassword3.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = errorpassword3,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }

            if(!errorpassword4.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = errorpassword4,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }
            if(!errorpassword5.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = errorpassword5,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }
            if(!errorpassword6.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = errorpassword6,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // textfield for confirm password
            TextField(
                value = confirmpassword,
                onValueChange = { confirmpassword = it },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = blue4,
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = blue2
                ),
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Check,
                        contentDescription = "Icon Check",
                        tint = blue2,
                        modifier = Modifier.padding(22.dp)
                    )
                },
                placeholder = {
                    Text(
                        text = "Confirm Password",
                        fontSize = 16.sp,
                        color = blue3,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                },
                trailingIcon = {
                    if (!crossforconfirmpassword) {
                        Icon(
                            Icons.Rounded.Clear,
                            contentDescription = "Icon Clear",
                            tint = blue2,
                            modifier = Modifier
                                .clickable(onClick = {
                                    confirmpassword = ""
                                    crossforconfirmpassword = false
                                })
                                .padding(22.dp)
                        )
                    }
                },
                shape = RoundedCornerShape(8.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }),
                modifier = Modifier
                    .border(1.dp, blue3, RectangleShape)
                    .fillMaxWidth()
            )

            if(!errorconfirmpassword.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = errorconfirmpassword,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Checkbox(
                    modifier = Modifier.padding(5.dp),
                    checked = checkbox,
                    onCheckedChange = { checkbox = it },
                    colors = CheckboxDefaults.colors(blue1),

                    )
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = grey1,
                                fontSize = 12.sp
                            )
                        ) {
                            append("Please Agree to our ")
                        }

                        withStyle(
                            style = SpanStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = blue2,
                            )
                        ) {
                            append("terms and condition*")
                        }
                    })
            }

            if(!errorcheckbox.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = errorcheckbox,
                    color = grey2,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(start = 20.dp)
                )
            }


            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    viewmodel.namevaliditycheck(fullname)
                    viewmodel.emailvaliditycheck(email)
                    viewmodel.phonevaliditycheck(mobilenumber)
                    viewmodel.passwordvaliditycheck(password)
                    viewmodel.confirmpasswordcheck(password,confirmpassword)
                    viewmodel.policyagreemnentcheck(checkbox)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(2.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = blue2)
            ) {

                Text(
                    text = "CREATE ACCOUNT",
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

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Already a member?",
                    color = grey1,
                    fontSize = 12.sp
                )

                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "SIGN IN", color = blue1)
                }
            }

        }

    }
}
