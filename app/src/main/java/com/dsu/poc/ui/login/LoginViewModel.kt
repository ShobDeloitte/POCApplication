package com.dsu.poc.project.ui.login

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * A view model class where all the business logic with respect to the login is taken care.
 */
class LoginViewModel: ViewModel() {

    /**
     * Checks the correctness of the creds provided
     *
     * @param username the user name value
     * @param password the password value
     * @return string value of the error message
     */

    fun validateCredentials(userName:String,password:String): MutableLiveData<String> {
        val loginErrorMessage = MutableLiveData<String>()
        if(isUserNameValid(userName)){
            if(!isPasswordValid(password)){
                loginErrorMessage.value = "Invalid Password"
            }else{
                loginErrorMessage.value = "Successful Login"
            }
        }else{
            loginErrorMessage.value = "Invalid Username"
        }

        return  loginErrorMessage
    }




    /**
     * Checks the correctness of the username provided
     *
     * @param username the user name value
     * @return boolean value
     */
   private fun isUserNameValid(userName: String): Boolean = (!TextUtils.isEmpty(userName) && userName == "test")
    /**
     * Checks the correctness of the password provided
     *
     * @param password the password value
     * @return boolean value
     */
    fun isPasswordValid(password: String): Boolean = (!TextUtils.isEmpty(password) && password == "test")

}