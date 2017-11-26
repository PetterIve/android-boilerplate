package com.petterive.model.app

/**
 * Created by petteriversen on 25/11/2017.
 */
enum class ServerError(errorCode: Int) {
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    CONFLICT(409),
    LOCAL_ERROR(0)
}