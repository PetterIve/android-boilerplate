package com.petterive.boilerplate.injection.component

import com.petterive.boilerplate.injection.modules.StoreModule
import com.petterive.boilerplate.ui.login.LoginPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by petteriversen on 25/11/2017.
 */

@Singleton
@Component(modules= arrayOf(StoreModule::class))
interface StoreComponent {
    fun inject(loginPresenter: LoginPresenter)
}