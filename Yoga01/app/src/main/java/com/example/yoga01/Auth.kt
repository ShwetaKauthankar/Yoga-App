package com.example.yoga01

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.*

object Auth {

    var TAG = "Authenticate Object"

    var firebaseAuth : FirebaseAuth = FirebaseAuth.getInstance()

    var authenticated : Boolean = false
        get() {
            return firebaseAuth.currentUser!=null
        }


    fun getLaunchIntent(from: Context) = Intent(from, StartActivity::class.java).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }



    fun firebaseAuthWithGoogle(acct: GoogleSignInAccount,context: Context) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)

        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                authenticated = true
                Log.d("signin","Successful")
                Toast.makeText(context,"Signed in Successfully", Toast.LENGTH_SHORT).show()
                context.startActivity(getLaunchIntent(context))
            } else {
                authenticated = false
                Toast.makeText(context,"Google sign in failed:(", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential,context: Context) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
            task ->
            if(task.isSuccessful){
               Log.d(TAG,"SigninWithCredential:success")

                val user : FirebaseUser? = task.result?.user
                Log.d(TAG,"userPhone=>${firebaseAuth.currentUser?.phoneNumber}")
                Log.d(TAG,"userEmail=>${firebaseAuth.currentUser?.email}")

                authenticated = true
                context.startActivity(getLaunchIntent(context))
            }
            else{
                Log.w(TAG,"signInWithCredential:failure", task.exception)
                if(task.exception is FirebaseAuthInvalidCredentialsException){

                }
            }
        }
    }

}