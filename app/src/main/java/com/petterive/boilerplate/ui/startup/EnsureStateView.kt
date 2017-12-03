package com.petterive.boilerplate.ui.startup

import com.petterive.boilerplate.ui.base.BaseView

/**
 * Created by petteriversen on 03/12/2017.
 */

interface EnsureStateView : BaseView {
    fun showLoadingState()
    fun proceedToApp()
}