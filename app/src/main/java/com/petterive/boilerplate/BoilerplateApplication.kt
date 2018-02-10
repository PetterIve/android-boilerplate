package com.petterive.boilerplate

import android.app.Application
import com.petterive.boilerplate.injection.components.DaggerLoginComponent
import com.petterive.boilerplate.injection.components.LoginComponent
import com.petterive.boilerplate.injection.modules.LoginModule

/**
 * Created by petteriversen on 24/11/2017.
 */
class BoilerplateApplication : Application() {

    companion object {
        lateinit var fluxComponent: LoginComponent
    }


    override fun onCreate() {
        super.onCreate()
        fluxComponent = DaggerLoginComponent.builder()
                .loginModule(LoginModule())
                .build()

    }
}