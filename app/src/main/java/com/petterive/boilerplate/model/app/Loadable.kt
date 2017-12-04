package com.petterive.boilerplate.model.app

import com.petterive.model.app.ServerError

/**
 * Created by petteriversen on 05/12/2017.
 */
abstract sealed class Loadable<T>

/**
 * We don't care for the types of these
 */
class NotInitialized<T>: Loadable<T>()
class InitialLoad<T>: Loadable<T>()
data class InitialError<T>(val error: ServerError): Loadable<T>()

data class ModelSet<T>(val model: T): Loadable<T>()
data class Updating<T>(val model: T): Loadable<T>()
data class UpdateError<T>(val model: T, val error: ServerError): Loadable<T>()
