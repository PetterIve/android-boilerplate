package com.petterive.boilerplate.ui.base

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by petteriversen on 24/11/2017.
 */

abstract class BaseActivity : AppCompatActivity(), BaseView {

    abstract val presenter: BasePresenter

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachFromView()
    }

    fun showFeedback(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }

}