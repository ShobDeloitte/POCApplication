package com.dsu.poc.project.ui.login.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.dsu.poc.BR

/*
A login model class to bind the data with layout
 */
class LoginModel : BaseObservable() {
    var userName: String? = null
        @Bindable get() = field
        set(userName) {
            field = userName
            notifyPropertyChanged(BR.userName)
        }
    var userPassWord: String? = null
        @Bindable get() = field
        set(userPassWord) {
            field = userPassWord
            notifyPropertyChanged(BR.userPassWord)
        }
}