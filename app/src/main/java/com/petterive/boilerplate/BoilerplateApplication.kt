package com.petterive.boilerplate

import android.app.Application
import com.petterive.boilerplate.injection.component.DaggerStoreComponent
import com.petterive.boilerplate.injection.component.StoreComponent
import com.petterive.boilerplate.injection.modules.StoreModule

/**
 * Created by petteriversen on 24/11/2017.
 */

class BoilerplateApplication : Application() {

    companion object {
        lateinit var storeComponent: StoreComponent
    }


    override fun onCreate() {
        super.onCreate()
        storeComponent = DaggerStoreComponent.builder()
                .storeModule(StoreModule())
                .build()
    }
}