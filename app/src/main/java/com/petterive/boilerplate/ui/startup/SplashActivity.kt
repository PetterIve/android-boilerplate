package com.petterive.boilerplate.ui.startup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by petteriversen on 24/11/2017.
 */

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //do nothing, simply not show a white screen while app is starting up
        startActivity(EnsureStateActivity.getStartIntent(this))
        finish()
    }

}