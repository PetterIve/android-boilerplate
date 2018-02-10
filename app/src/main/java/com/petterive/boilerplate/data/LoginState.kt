package com.petterive.boilerplate.data

import com.petterive.boilerplate.model.app.Loadable
import com.petterive.model.User
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by petteriversen on 04/02/2018.
 */

interface LoginState {
    val userSubject: BehaviorSubject<Loadable<User>>
    fun updateLoginState(newState: Loadable<User>)
}