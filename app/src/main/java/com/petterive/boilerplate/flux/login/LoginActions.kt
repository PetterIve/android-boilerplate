package com.petterive.boilerplate.flux.login

import android.os.Handler
import com.petterive.boilerplate.BoilerplateApplication
import com.petterive.model.User
import com.petterive.model.app.Loadable
import com.petterive.model.app.ServerError
import javax.inject.Inject

/**
 * Created by petteriversen on 26/11/2017.
 */

class LoginActions {
    @Inject
    lateinit var loginStore: LoginStore

    init {
        BoilerplateApplication.fluxComponent.inject(this)
    }

    fun doLogin(username: String, password: String) {
        loginStore.updateLoginState(Loadable(isLoading=true))
        Handler().postDelayed({
            if(username.toLowerCase().equals("petterive") && password.toLowerCase().equals("petterive")) {
                loginStore.updateLoginState(Loadable(model=User(username, password)))
            } else {
                loginStore.updateLoginState(Loadable(error= ServerError.BAD_REQUEST))
            }
        }, 2000)
    }

}