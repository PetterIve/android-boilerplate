package com.petterive.boilerplate.flux.login

import com.petterive.boilerplate.flux.BaseStore
import com.petterive.boilerplate.model.app.Loadable
import com.petterive.boilerplate.model.app.NotInitialized
import com.petterive.model.User
import io.reactivex.subjects.BehaviorSubject


/**
 * Created by petteriversen on 24/11/2017.
 */

class LoginStore : BaseStore() {

    val userSubject: BehaviorSubject<Loadable<User>> = BehaviorSubject.createDefault(NotInitialized())

    fun updateLoginState(newState: Loadable<User>) {
        userSubject.onNext(newState)
    }
}