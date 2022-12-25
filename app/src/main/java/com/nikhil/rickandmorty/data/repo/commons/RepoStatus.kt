package com.nikhil.rickandmorty.data.repo.commons



data class RepoStatus<out T>(
    val status: RepoState,
    val data: T?,
    val code: Int? = null,
    val message: String? = null
) {
    companion object {

        fun <T> success(data: T?): RepoStatus<T> {
            return RepoStatus(RepoState.SUCCESS, data)
        }

        fun <T> tokenError(): RepoStatus<T> {
            return RepoStatus(RepoState.TOKEN_ERROR, null)
        }

        fun <T> serverError(): RepoStatus<T> {
            return RepoStatus(RepoState.SERVER_ERROR, null)
        }

        fun <T> responseError(code: Int?, message: String?): RepoStatus<T> {
            return RepoStatus(
                RepoState.RESPONSE_ERROR,
                null,
                code,
                message
            )
        }

        fun <T> internetError(): RepoStatus<T> {
            return RepoStatus(RepoState.INTERNET_ERROR, null)
        }

        fun <T> withoutContent(): RepoStatus<T> {
            return RepoStatus(RepoState.RESPONSE_EMPTY, null)
        }
    }
}
