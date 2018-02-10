package com.petterive.boilerplate.ui.base

import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by petteriversen on 24/11/2017.
 */

abstract class BaseActivity : AppCompatActivity(), BaseView {

    abstract val presenter: BasePresenter

    fun showFeedback(title: String, text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    fun showFeedback(titleResId: Int, textResId: Int) {
        Toast.makeText(this, textResId, Toast.LENGTH_LONG).show()
    }

}