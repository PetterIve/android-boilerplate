package com.petterive.model.app

/**
 * Created by petteriversen on 25/11/2017.
 */
class Loadable<T>(
        val model: T? = null,
        val isLoading: Boolean = false,
        val isLoadingSilently: Boolean = false,
        val error: ServerError? = null
) {
    val state: State

    init {
        state = when{
            model != null -> State.MODEL_SET
            isLoading -> State.LOADING
            isLoadingSilently -> State.LOADING_SILENTLY
            error != null -> State.ERROR
            else -> State.NOT_INITIALIZED
        }
    }

    enum class State {
        LOADING,
        LOADING_SILENTLY,
        ERROR,
        MODEL_SET,
        NOT_INITIALIZED
    }
}