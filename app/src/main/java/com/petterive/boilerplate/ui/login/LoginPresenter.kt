package com.petterive.boilerplate.ui.login

import com.petterive.boilerplate.data.LoginMutations
import com.petterive.boilerplate.data.LoginState
import com.petterive.boilerplate.data.flux.login.LoginStore
import com.petterive.boilerplate.model.app.Loadable
import com.petterive.boilerplate.model.app.ModelSet
import com.petterive.boilerplate.model.app.UpdateError
import com.petterive.boilerplate.model.app.Updating
import com.petterive.boilerplate.ui.base.BasePresenter
import com.petterive.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by petteriversen on 24/11/2017.
 */

class LoginPresenter @Inject constructor(
        var loginMutations: LoginMutations,
        var loginState: LoginState
) : BasePresenter()
{

    private lateinit var loginView: LoginView

    init {
        loginState.userSubject
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { userLoadable -> onLoginModelChanged(userLoadable) }
    }


    fun attachToView(loginView: LoginView) {
        this.loginView = loginView
    }

    private fun onLoginModelChanged(userLoadable: Loadable<User>) {
        when(userLoadable) {
            is Updating -> loginView.showLoggingIn()
            is ModelSet -> loginView.onLoginSuccess(userLoadable.model)
            is UpdateError -> loginView.showLoginError(userLoadable.error)
        }
    }

    fun login(username: String, password: String) {
        loginMutations.doLogin(username, password)
    }


}