package com.abdat.cryptotracker.core.domain.util

enum class NetworkError: Error {
    REQUEST_TIMEOUT,
    TOO_MANY_REQUEST,
    SERVER_ERROR,
    UNKNOWN_ERROR,
    SERIALIZATION_ERROR,
    NO_INTERNET_CONNECTION,
}