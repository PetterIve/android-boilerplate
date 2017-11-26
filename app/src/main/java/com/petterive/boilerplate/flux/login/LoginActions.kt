package com.petterive.boilerplate.flux.login

import android.os.Handler
import com.petterive.model.User
import com.petterive.model.app.Loadable

/**
 * Created by petteriversen on 26/11/2017.
 */

class LoginActions(val loginStore: LoginStore) {

    fun doLogin(userName: String, password: String) {
        loginStore.updateLoginState(Loadable(isLoading=true))
        Handler().postDelayed({loginStore.updateLoginState(Loadable(model=User(userName, password)))}, 2000)
    }

}