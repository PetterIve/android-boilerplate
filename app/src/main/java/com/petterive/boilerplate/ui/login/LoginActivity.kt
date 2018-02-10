package com.petterive.boilerplate.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.petterive.boilerplate.BoilerplateApplication
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

        BoilerplateApplication.fluxComponent.inject(this)
        bLogin.setOnClickListener { presenter.login(etPassword.text.toString(), etUserName.text.toString()) }
    }

    override fun showLoggingIn() {
        startLoginLoading()
    }

    override fun showAwaitingUserInput() {
        stopLoginLoading()
    }

    override fun showForgotEmail() {
    }

    override fun showLoginError(serverError: ServerError) {
        stopLoginLoading()
        when(serverError) {
            ServerError.BAD_REQUEST -> showFeedback("Error","Wrong username or password")
            else -> showFeedback("Error","Something went wrong")
        }
    }

    override fun onLoginSuccess(model: User) {
        stopLoginLoading()
        showFeedback("Success!","Login successful")
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