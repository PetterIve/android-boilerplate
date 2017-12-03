package com.petterive.boilerplate.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.petterive.boilerplate.R
import com.petterive.boilerplate.ui.base.BaseActivity
import com.petterive.model.User
import com.petterive.model.app.ServerError
import kotlinx.android.synthetic.main.activity_login.*


/**
 * Created by petteriversen on 24/11/2017.
 */


class LoginActivity : BaseActivity(), LoginView {

    override lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)

        bLogin.setOnClickListener { presenter.login(etPassword.text.toString(), etUserName.text.toString()) }
    }

    override fun showLoggingIn(): LoginView.LoginViewState {
        startLoginLoading()
        return LoginView.LoginViewState.LOGGING_IN
    }

    override fun showAwaitingUserInput(): LoginView.LoginViewState {
        stopLoginLoading()
        return LoginView.LoginViewState.AWAITING_USER_INPUT
    }

    override fun showForgotEmail(): LoginView.LoginViewState {
        return LoginView.LoginViewState.REGISTERING
    }

    override fun showLoginError(serverError: ServerError): LoginView.LoginViewState {
        when(serverError) {
            ServerError.BAD_REQUEST -> showFeedback("Wrong username or password")
            else -> showFeedback("Something went wrong")
        }
        return LoginView.LoginViewState.SHOWING_LOGIN_ERROR
    }

    override fun onLoginSuccess(model: User): LoginView.LoginViewState {
        stopLoginLoading()
        showFeedback("Login successful")
        return LoginView.LoginViewState.LOGIN_SUCCESS
    }

    private fun startLoginLoading() {
        pbLoggingIn.visibility = View.VISIBLE
        llLoginContainer.visibility = View.GONE
    }

    private fun stopLoginLoading() {
        pbLoggingIn.visibility = View.GONE
        llLoginContainer.visibility = View.VISIBLE
    }

    companion object {
        fun getStartIntent (context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

}