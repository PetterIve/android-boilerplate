package com.petterive.boilerplate.data

/**
 * Created by petteriversen on 09/02/2018.
 */
interface LoginMutations {
    fun doLogin(username: String, password: String)
}