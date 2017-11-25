package com.petterive.model.app

/**
 * Created by petteriversen on 25/11/2017.
 */
enum class ModelError(errorCode: Int) {
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    CONFLICT(409),
    LOCAL_ERROR(0)
}