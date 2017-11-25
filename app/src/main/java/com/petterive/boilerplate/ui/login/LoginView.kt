package com.petterive.boilerplate.ui.login

/**
 * Created by petteriversen on 25/11/2017.
 */

interface LoginView {

    fun showLoggingIn(): LoginViewState
    fun showAwaitingUserInput(): LoginViewState
    fun showForgotEmail(): LoginViewState

    enum class LoginViewState {
        AWAITING_USER_INPUT,
        LOGGING_IN,
        REGISTERING
    }

}