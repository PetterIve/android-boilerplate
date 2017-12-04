package com.petterive.boilerplate.flux.login

import android.os.Handler
import com.petterive.boilerplate.BoilerplateApplication
import com.petterive.boilerplate.model.app.*
import com.petterive.model.User
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
        val user = User(username, password)
        loginStore.updateLoginState(Updating(user))
        Handler().postDelayed({
            if(username.toLowerCase().equals("petterive") && password.toLowerCase().equals("petterive")) {
                loginStore.updateLoginState(ModelSet(user))
            } else {
                loginStore.updateLoginState(UpdateError(error= ServerError.BAD_REQUEST, model = user))
            }
        }, 2000)
    }

}