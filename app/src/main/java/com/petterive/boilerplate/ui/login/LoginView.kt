package com.petterive.boilerplate.ui.login

import com.petterive.boilerplate.ui.base.BaseView
import com.petterive.model.User
import com.petterive.model.app.ServerError

/**
 * Created by petteriversen on 25/11/2017.
 */

interface LoginView: BaseView {

    fun onLoginSuccess(model: User)
    fun showLoggingIn()
    fun showAwaitingUserInput()
    fun showForgotEmail()
    fun showLoginError(serverError: ServerError)

}