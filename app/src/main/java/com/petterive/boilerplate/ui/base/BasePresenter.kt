package com.petterive.boilerplate.ui.base

import com.anadeainc.rxbus.Bus
import com.anadeainc.rxbus.BusProvider

/**
 * Created by petteriversen on 24/11/2017.
 */

abstract class BasePresenter {

    private var bus: Bus = BusProvider.getInstance()

    constructor() {
        bus.register(this)
    }

    fun detachFromView() {
        bus.unregister(this)
    }

}