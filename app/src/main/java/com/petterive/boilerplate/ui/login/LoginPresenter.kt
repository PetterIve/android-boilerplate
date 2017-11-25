package com.petterive.boilerplate.ui.login

import com.petterive.boilerplate.BoilerplateApplication
import com.petterive.boilerplate.flux.login.LoginStore
import com.petterive.boilerplate.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by petteriversen on 24/11/2017.
 */

class LoginPresenter: BasePresenter {

    @Inject lateinit var loginStore: LoginStore

    private var viewState = LoginView.LoginViewState.AWAITING_USER_INPUT

    constructor(loginView: LoginView): super() {
        BoilerplateApplication.storeComponent.inject(this)
        loginStore.toString()
    }


}