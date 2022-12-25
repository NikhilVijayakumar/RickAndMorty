package com.nikhil.rickandmorty.data.repo.commons

import androidx.annotation.Keep

@Keep
enum class RepoState {
    SUCCESS,
    RESPONSE_ERROR,
    SERVER_ERROR,
    TOKEN_ERROR,
    INTERNET_ERROR,
    RESPONSE_EMPTY
}
