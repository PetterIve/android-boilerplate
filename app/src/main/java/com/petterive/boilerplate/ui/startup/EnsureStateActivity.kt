package com.petterive.boilerplate.ui.startup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.petterive.boilerplate.R
import com.petterive.boilerplate.ui.base.BaseActivity
import com.petterive.boilerplate.ui.login.LoginActivity


/**
 * Created by petteriversen on 24/11/2017.
 */

class EnsureStateActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ensure_state)
        //TODO execute logic related to login, fetch server side data etc.
        startActivity(LoginActivity.getStartIntent(this))
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, EnsureStateActivity::class.java)
        }
    }

}