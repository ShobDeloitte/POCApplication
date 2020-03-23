package com.dsu.poc.project.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dsu.poc.R
import com.dsu.poc.base.BaseFragment
import com.dsu.poc.databinding.LoginFragmentBinding
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A Fragment class to display the Login functionality to the User
 */

class LoginFragment : BaseFragment() {
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val loginBinder: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login, container, false
        )
        val loginView = loginBinder.root
        loginBinder.loginbtn.setOnClickListener {
            initObservers()
        }
        return loginView
    }


    /**
     * Initialising the Observers
     */
    private fun initObservers() {
        loginViewModel.validateCredentials(
            editUserName.text.toString(),
            editPassword.text.toString()
        ).observe(this, Observer<String> { message ->
            when (message) {
                resources.getString(R.string.login_success) -> {
                }
                else -> showAlertDialog {
                    setTitle(resources.getString(R.string.login_error))
                    setMessage(message)
                    positiveButton(resources.getString(R.string.login_ok)) {
                    }
                }
            }
        })
    }
}