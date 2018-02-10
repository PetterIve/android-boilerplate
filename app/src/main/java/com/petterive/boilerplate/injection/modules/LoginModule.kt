package com.petterive.boilerplate.injection.modules

import com.petterive.boilerplate.data.flux.login.LoginActions
import com.petterive.boilerplate.data.flux.login.LoginStore
import com.petterive.boilerplate.ui.login.LoginPresenter
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
        return LoginActions(provideLoginStore())
    }

    @Provides
    @Singleton
    fun loginPresenter(): LoginPresenter {
        return LoginPresenter(
                provideLoginActions(),
                provideLoginStore()
        )
    }

}