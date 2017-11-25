package com.petterive.model.app

/**
 * Created by petteriversen on 25/11/2017.
 */
abstract class Loadable<T> {
    val model: T? = null
    val isLoading: Boolean = false
    val isLoadingSilently: Boolean = false
    val error: ModelError? = null

    fun getState(): State {
        if(isLoading) return State.LOADING
        else if(isLoadingSilently) return State.LOADING_SILENTLY
        else if(error != null) return State.ERROR
        else if(model != null) return State.MODEL_SET
        else return State.NOT_INITIALIZED
    }

    enum class State {
        LOADING,
        LOADING_SILENTLY,
        ERROR,
        MODEL_SET,
        NOT_INITIALIZED
    }
}