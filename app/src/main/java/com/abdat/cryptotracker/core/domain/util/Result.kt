package com.abdat.cryptotracker.core.domain.util


typealias DomainError = Error


sealed interface Result<out E : Error, out D> {
    data class Success<out D>(val data: D) : Result<Nothing, D>
    data class Error<out E : DomainError>(val error: E) : Result<E, Nothing>
}

inline fun <E : Error, T, R> Result<E, T>.map(map: (T) -> R): Result<E, R> {
    return when (this) {
        is Result.Error -> Result.Error(error)
        is Result.Success -> Result.Success(map(data))
    }
}

fun <E: Error,T> Result<E, T>.asEmptyDataResult(): EmptyResult<E> {
    return map {}
}

inline fun <E: Error,T> Result<E, T>.onSuccess(action: (T) -> Unit): Result<E, T> {
    return when(this) {
        is Result.Error -> this
        is Result.Success -> {
            action(data)
            this
        }
    }
}

inline fun < E: Error,T> Result<E,T>.onError(action: (E) -> Unit): Result<E, T> {
    return when(this) {
        is Result.Error -> {
            action(error)
            this
        }
        is Result.Success -> this
    }
}

typealias EmptyResult<E> = Result<E,Unit>