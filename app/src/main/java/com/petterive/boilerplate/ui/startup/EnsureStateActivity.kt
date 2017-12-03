package com.petterive.boilerplate.ui.startup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.petterive.boilerplate.R
import com.petterive.boilerplate.ui.base.BaseActivity
import com.petterive.boilerplate.ui.base.BasePresenter
import com.petterive.boilerplate.ui.login.LoginActivity


/**
 * Created by petteriversen on 24/11/2017.
 */

class EnsureStateActivity: BaseActivity(), EnsureStateView {
    override fun showLoadingState() {
    }

    override fun proceedToApp() {
    }

    override lateinit var presenter: EnsureStatePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ensure_state)
        //TODO execute logic related to login, fetch server side data etc.
        presenter = EnsureStatePresenter(this)
        startActivity(LoginActivity.getStartIntent(this))
        finish()
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, EnsureStateActivity::class.java)
        }
    }

}