package com.petterive.boilerplate.ui.login

import com.petterive.boilerplate.BoilerplateApplication
import com.petterive.boilerplate.flux.login.LoginActions
import com.petterive.boilerplate.flux.login.LoginStore
import com.petterive.boilerplate.ui.base.BasePresenter
import com.petterive.model.User
import com.petterive.model.app.Loadable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by petteriversen on 24/11/2017.
 */

class LoginPresenter(val loginView: LoginView) : BasePresenter() {

    @Inject lateinit var loginActions: LoginActions
    @Inject lateinit var loginStore: LoginStore

    private var viewState = LoginView.LoginViewState.AWAITING_USER_INPUT

    init {
        BoilerplateApplication.fluxComponent.inject(this)
        loginStore.userSubject
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { userModel -> onLoginModelChanged(userModel) }
    }

    private fun onLoginModelChanged(userModel: Loadable<User>) {
        when(userModel.state) {
            Loadable.State.LOADING -> loginView.showLoggingIn()
            Loadable.State.MODEL_SET -> loginView.onLoginSuccess(userModel.model!!)
            Loadable.State.ERROR -> loginView.showLoginError(userModel.error!!)
        }
    }

    fun login(username: String, password: String) {
        loginActions.doLogin(username, password)
    }


}