package com.petterive.boilerplate.injection.modules.flux

import com.petterive.boilerplate.flux.login.LoginActions
import com.petterive.boilerplate.flux.login.LoginStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by petteriversen on 26/11/2017.
 */
@Module
class LoginModule {
    @Provides
    @Singleton
    fun provideLoginStore(): LoginStore {
        return LoginStore()
    }

    @Provides
    @Singleton
    fun provideLoginActions(): LoginActions {
        return LoginActions()
    }

}