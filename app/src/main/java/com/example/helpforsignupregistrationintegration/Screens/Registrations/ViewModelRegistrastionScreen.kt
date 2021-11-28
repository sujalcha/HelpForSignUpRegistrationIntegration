package com.example.helpforsignupregistrationintegration.Screens.Registrations

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelRegistrastionScreen : ViewModel() {

    var fullname = mutableStateOf("")
    val email = mutableStateOf("")
    val mobilenumber = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmpassword = mutableStateOf("")
    val checkbox = mutableStateOf(false)

    var crossforfullname = mutableStateOf(false)
    val crossforemail = mutableStateOf(false)
    val crossformobilenumber = mutableStateOf(false)
    val crossforpassword = mutableStateOf(false)
    val crossforconfirmpassword = mutableStateOf(false)

    val errorfullname = mutableStateOf("")
    val erroremail = mutableStateOf("")
    val errormobilenumber = mutableStateOf("")

    val errorpassword1 = mutableStateOf("")
    val errorpassword2 = mutableStateOf("")
    val errorpassword3 = mutableStateOf("")
    val errorpassword4 = mutableStateOf("")
    val errorpassword5 = mutableStateOf("")
    val errorpassword6 = mutableStateOf("")

    val errorconfirmpassword = mutableStateOf("")
    val errorcheckbox = mutableStateOf("")


    fun namevaliditycheck(fullname: String) {
        if (fullname.isNullOrEmpty()) {
            errorfullname.value = "Name cannot be empty or null"
        } else {
            errorfullname.value = ""
        }

    }

    fun emailvaliditycheck(email: String) {
        if (email.isNullOrEmpty()) {
            erroremail.value = "Email cannot be null or empty."
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            erroremail.value = "Please provide valid email id."
        } else {
            erroremail.value = ""
        }

    }

    fun phonevaliditycheck(mobilenumber: String) {
        if (mobilenumber.isNullOrEmpty()) {
            errormobilenumber.value = "Mobile number is mandatory."
        } else if (!android.util.Patterns.PHONE.matcher(mobilenumber).matches()) {
            errormobilenumber.value = "Mobile number not valid"
        } else {
            errormobilenumber.value = "ok"
        }

    }

    fun passwordvaliditycheck(password: String) {

        val regex2 = ("^(?=.*[a-z]).+$").toRegex()
        val regex3 = ("^(?=.*[A-Z]).+$").toRegex()
        val regex4 = ("^(?=.*[0-9]).+$").toRegex()
        val regex5 = ("^(?=.*[-+_!@#\$%^&*., ?]).+$").toRegex()
        val regex6 = ("^.{8,}").toRegex()


        if (password.isNullOrEmpty()) {
            errorpassword1.value = "Password cannot be empty."
        } else {
            errorpassword1.value = ""
        }

        if (!password.matches(regex2)) {
            errorpassword2.value = "Password must have lowercase characters."
        } else {
            errorpassword2.value = ""
        }

        if (!password.matches(regex3)) {
            errorpassword3.value = "Password must have capital letters."
        } else {
            errorpassword3.value = ""
        }
        if (!password.matches(regex4)) {
            errorpassword4.value = "Password must have numerical characters."
        } else {
            errorpassword4.value = ""
        }
        if (!password.matches(regex5)) {
            errorpassword5.value = "Password must have special characters."
        } else {
            errorpassword5.value = ""
        }
        if (!password.matches(regex6)) {
            errorpassword6.value = "Password must have atleast 8 characters."
        } else {
            errorpassword6.value = ""
        }
    }

    fun confirmpasswordcheck(password: String, confirmpassword:String) {
        if (!password.equals(confirmpassword) ) {
            errorconfirmpassword.value = "Passwords do not match."
        } else {
            errorconfirmpassword.value = ""
        }

    }

    fun policyagreemnentcheck(checkbox:Boolean){
        if(!checkbox){
            errorcheckbox.value = "Please agree to the terms and condition."
        }
        else{
            errorcheckbox.value = ""
        }
    }

}


//    private fun createAccount(email: String, password: String) {
//        // [START create_user_with_email]
//        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d("createUserWithEmail", "createUserWithEmail:success")
//                    val user = auth.currentUser
//                    //updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w("createUserWithEmail", "createUserWithEmail:failure", task.exception)
//                 //   updateUI(null)
//                }
//            }
//        // [END create_user_with_email]
//    }
