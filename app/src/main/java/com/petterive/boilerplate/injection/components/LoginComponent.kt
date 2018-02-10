package com.petterive.boilerplate.injection.components

import com.petterive.boilerplate.data.flux.login.LoginActions
import com.petterive.boilerplate.injection.modules.LoginModule
import com.petterive.boilerplate.ui.login.LoginActivity
import com.petterive.boilerplate.ui.login.LoginPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by petteriversen on 26/11/2017.
 */

@Singleton
@Component(modules = arrayOf(LoginModule::class))
interface LoginComponent {
    fun inject(loginPresenter: LoginPresenter)
    fun inject(loginActions: LoginActions)
    fun inject(loginActivity: LoginActivity)
}