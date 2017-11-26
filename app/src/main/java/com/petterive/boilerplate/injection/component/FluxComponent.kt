package com.petterive.boilerplate.injection.component

import com.petterive.boilerplate.injection.modules.flux.LoginModule
import com.petterive.boilerplate.ui.login.LoginPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by petteriversen on 26/11/2017.
 */

@Singleton
@Component(modules = arrayOf(LoginModule::class))
interface FluxComponent {
    fun inject(loginPresenter: LoginPresenter)
}