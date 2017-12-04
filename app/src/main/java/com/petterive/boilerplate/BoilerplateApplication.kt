package com.petterive.boilerplate

import android.app.Application
import com.petterive.boilerplate.injection.component.DaggerFluxComponent
import com.petterive.boilerplate.injection.component.FluxComponent
import com.petterive.boilerplate.injection.modules.flux.LoginModule

/**
 * Created by petteriversen on 24/11/2017.
 */
class BoilerplateApplication : Application() {

    companion object {
        lateinit var fluxComponent: FluxComponent
    }


    override fun onCreate() {
        super.onCreate()
        fluxComponent = DaggerFluxComponent.builder()
                .loginModule(LoginModule())
                .build()

    }
}