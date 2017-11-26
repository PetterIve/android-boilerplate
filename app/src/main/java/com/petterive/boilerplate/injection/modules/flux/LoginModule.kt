package com.petterive.boilerplate.injection.modules.flux

import com.anadeainc.rxbus.Bus
import com.petterive.boilerplate.flux.login.LoginActions
import com.petterive.boilerplate.flux.login.LoginStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by petteriversen on 26/11/2017.
 */
@Module
class LoginModule(val bus: Bus) {
    @Provides
    @Singleton
    fun providesLoginStore(): LoginStore {
        return LoginStore(bus)
    }

    @Provides
    @Singleton
    fun provideLoginActions(): LoginActions {
        return LoginActions(providesLoginStore())
    }

}