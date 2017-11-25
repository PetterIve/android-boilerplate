package com.petterive.boilerplate.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.petterive.boilerplate.R
import com.petterive.boilerplate.ui.base.BaseActivity


/**
 * Created by petteriversen on 24/11/2017.
 */


class LoginActivity : BaseActivity(), LoginView {

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenter(this)
    }

    override fun showLoggingIn(): LoginView.LoginViewState {
        return LoginView.LoginViewState.LOGGING_IN
    }

    override fun showAwaitingUserInput(): LoginView.LoginViewState {
        return LoginView.LoginViewState.AWAITING_USER_INPUT
    }

    override fun showForgotEmail(): LoginView.LoginViewState {
        return LoginView.LoginViewState.REGISTERING
    }

    companion object {
        fun getStartIntent (context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

}