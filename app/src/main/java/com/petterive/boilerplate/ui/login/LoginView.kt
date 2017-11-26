package com.petterive.boilerplate.ui.login

import com.petterive.model.User
import com.petterive.model.app.ServerError

/**
 * Created by petteriversen on 25/11/2017.
 */

interface LoginView {

    fun onLoginSuccess(model: User): LoginViewState
    fun showLoggingIn(): LoginViewState
    fun showAwaitingUserInput(): LoginViewState
    fun showForgotEmail(): LoginViewState
    fun showLoginError(serverError: ServerError): LoginViewState

    enum class LoginViewState {
        AWAITING_USER_INPUT,
        LOGGING_IN,
        REGISTERING,
        SHOWING_LOGIN_ERROR,
        LOGIN_SUCCESS
    }

}