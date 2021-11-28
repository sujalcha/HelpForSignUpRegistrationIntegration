//package com.example.helpforsignupregistrationintegration.Screens
//
//import android.app.Application
//import android.widget.Toast
//import androidx.lifecycle.MutableLiveData
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//
//
//class AuthAppRepository {
//    private var application: Application? = nullull
//
//    private var firebaseAuth: FirebaseAuth? = null
//    private var userLiveData: MutableLiveData<FirebaseUser?>? = null
//    private var loggedOutLiveData: MutableLiveData<Boolean>? = null
//
//    fun AuthAppRepository(application: Application?) {
//        this.application = application
//        firebaseAuth = FirebaseAuth.getInstance()
//        userLiveData = MutableLiveData()
//        loggedOutLiveData = MutableLiveData()
//        if (firebaseAuth!!.currentUser != null) {
//            userLiveData!!.postValue(firebaseAuth!!.currentUser)
//            loggedOutLiveData!!.postValue(false)
//        }
//    }
//
//    private fun signIn(email: String, password: String) {
//        // [START sign_in_with_email]
//        firebaseAuth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "signInWithEmail:success")
//                    val user = auth.currentUser
//                //    updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w(TAG, "signInWithEmail:failure", task.exception)
//                    Toast.makeText(baseContext, "Authentication failed.",
//                        Toast.LENGTH_SHORT).show()
//                 //   updateUI(null)
//                }
//            }
//        // [END sign_in_with_email]
//    }
//
//
//    fun register(email: String?, password: String?) {
//        firebaseAuth!!.createUserWithEmailAndPassword(email!!, password!!)
//            .addOnCompleteListener(
//                application!!.mainExecutor
//            ) { task ->
//                if (task.isSuccessful) {
//                    userLiveData!!.postValue(firebaseAuth!!.currentUser)
//                } else {
//                    Toast.makeText(
//                        application!!.applicationContext,
//                        "Registration Failure: " + task.exception.getMessage(),
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//    }
//
//    fun logOut() {
//        firebaseAuth!!.signOut()
//        loggedOutLiveData!!.postValue(true)
//    }
//
//    fun getUserLiveData(): MutableLiveData<FirebaseUser?>? {
//        return userLiveData
//    }
//
//    fun getLoggedOutLiveData(): MutableLiveData<Boolean>? {
//        return loggedOutLiveData
//    }
//}