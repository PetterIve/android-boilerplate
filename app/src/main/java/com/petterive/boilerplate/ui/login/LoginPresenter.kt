package com.petterive.boilerplate.ui.login

import com.petterive.boilerplate.BoilerplateApplication
import com.petterive.boilerplate.flux.login.LoginActions
import com.petterive.boilerplate.flux.login.LoginStore
import com.petterive.boilerplate.model.app.*
import com.petterive.boilerplate.ui.base.BasePresenter
import com.petterive.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by petteriversen on 24/11/2017.
 */

class LoginPresenter(val loginView: LoginView) : BasePresenter() {

    @Inject lateinit var loginActions: LoginActions
    @Inject lateinit var loginStore: LoginStore

    init {
        BoilerplateApplication.fluxComponent.inject(this)
        loginStore.userSubject
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { userLoadable -> onLoginModelChanged(userLoadable) }
    }

    private fun onLoginModelChanged(userLoadable: Loadable<User>) {
        when(userLoadable) {
            is Updating -> loginView.showLoggingIn()
            is ModelSet -> loginView.onLoginSuccess(userLoadable.model)
            is UpdateError -> loginView.showLoginError(userLoadable.error)
        }
    }

    fun login(username: String, password: String) {
        loginActions.doLogin(username, password)
    }


}