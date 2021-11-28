package com.example.helpforsignupregistrationintegration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helpforsignupregistrationintegration.Screens.Login.LoginScreen
import com.example.helpforsignupregistrationintegration.Screens.Registrations.RegistrationsScreen
import com.example.helpforsignupregistrationintegration.Screens.Registrations.ViewModelRegistrastionScreen
import com.example.helpforsignupregistrationintegration.ui.theme.HelpForSignUpRegistrationIntegrationTheme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelpForSignUpRegistrationIntegrationTheme {
                // A surface container using the 'background' color from the theme
                RegistrationsScreen(ViewModelRegistrastionScreen())
            }
        }
    }

    // [START on_start_check_user]
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if(currentUser != null){
//         //   reload();
//        }
    }
    // [END on_start_check_user]
}


