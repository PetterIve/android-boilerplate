package com.petterive.boilerplate.injection.modules

import com.petterive.boilerplate.flux.login.LoginStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by petteriversen on 25/11/2017.
 */
@Module
class StoreModule {
    @Provides
    @Singleton
    fun providesLoginStore(): LoginStore {
        return LoginStore()
    }

}