package com.petterive.boilerplate.ui.login

import com.anadeainc.rxbus.BusProvider
import com.anadeainc.rxbus.Subscribe
import com.petterive.boilerplate.BoilerplateApplication
import com.petterive.boilerplate.flux.login.LoginActions
import com.petterive.boilerplate.flux.login.LoginStore
import com.petterive.boilerplate.ui.base.BasePresenter
import com.petterive.model.app.Loadable
import com.petterive.model.app.ServerError
import javax.inject.Inject

/**
 * Created by petteriversen on 24/11/2017.
 */

class LoginPresenter(val loginView: LoginView) : BasePresenter() {

    @Inject lateinit var loginActions: LoginActions

    private var viewState = LoginView.LoginViewState.AWAITING_USER_INPUT

    init {
        BoilerplateApplication.fluxComponent.inject(this)
        BusProvider.getInstance().register(this)
    }

    @Subscribe
    fun onLoginStateChanged(event: LoginStore.LoginStateChangedEvent) {
        when(event.loadable.state) {
            Loadable.State.MODEL_SET -> loginView.onLoginSuccess(event.loadable.model!!)
            Loadable.State.LOADING -> loginView.showLoggingIn()
        }
    }

    fun login(username: String, password: String) {
        if(username.toLowerCase().equals("petterive") && password.toLowerCase().equals("petterive")) {
            loginActions.doLogin(username, password)
        } else {
            viewState = loginView.showLoginError(ServerError.BAD_REQUEST)
        }
    }


}