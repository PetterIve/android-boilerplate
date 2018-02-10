package com.petterive.boilerplate.data.flux.login

import com.petterive.boilerplate.data.LoginState
import com.petterive.boilerplate.data.flux.BaseStore
import com.petterive.boilerplate.model.app.Loadable
import com.petterive.boilerplate.model.app.NotInitialized
import com.petterive.model.User
import io.reactivex.subjects.BehaviorSubject


/**
 * Created by petteriversen on 24/11/2017.
 */

class LoginStore : BaseStore(), LoginState {

    override val userSubject: BehaviorSubject<Loadable<User>> = BehaviorSubject.createDefault(NotInitialized())

    override fun updateLoginState(newState: Loadable<User>) {
        userSubject.onNext(newState)
    }
}