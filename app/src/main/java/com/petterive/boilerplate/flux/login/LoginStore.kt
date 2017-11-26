package com.petterive.boilerplate.flux.login

import com.anadeainc.rxbus.Bus
import com.petterive.boilerplate.flux.BaseStore
import com.petterive.model.User
import com.petterive.model.app.Loadable


/**
 * Created by petteriversen on 24/11/2017.
 */

class LoginStore(bus: Bus) : BaseStore(bus) {

    fun updateLoginState(state: Loadable<User>) {
        bus.post(LoginStateChangedEvent(state))
    }

    class LoginStateChangedEvent(val loadable: Loadable<User>)

}