package com.nikhil.rickandmorty.data.repo.commons

import android.util.Log
import com.nikhil.rickandmorty.data.repo.commons.RepoStatus.Companion.success
import retrofit2.HttpException
import java.io.EOFException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class ResponseHandler {

    fun <T : Any> handleSuccess(data: T?): RepoStatus<T> = success(data)
    fun <T : Any> handleException(
        e: Exception,
        extraInfo: String? = null
    ): RepoStatus<T> {
        return when (e) {
            is HttpException -> {
                Log.i("ServerResponse", "HttpException, the error is ${e.code()}")
                if (e.code() == 401)
                    RepoStatus.tokenError()
                else
                    RepoStatus.responseError(e.code(), extraInfo)
            }
            is SocketTimeoutException -> {
                Log.i("ServerResponse", "SocketTimeoutException")
                RepoStatus.serverError()
            }
            is NullPointerException, is EOFException -> {
                Log.i(
                    "ServerResponse",
                    "NullPointerException, KotlinNullPointerException, EOFException"
                )
                RepoStatus.withoutContent()
            }
            is UnknownHostException -> {
                if(isConnected()){
                    Log.i("ServerResponse", "UnknownHostException")
                    RepoStatus.serverError()
                }else{
                    Log.i("ServerResponse", "Internet error")
                    RepoStatus.internetError()
                }
            }
            else -> {
                Log.i("ServerResponse", "Server error")
                RepoStatus.serverError()
            }
        }
    }

    @Throws(InterruptedException::class, IOException::class)
    fun isConnected(): Boolean {
        val command = "ping -c 1 google.com"
        return Runtime.getRuntime().exec(command).waitFor() == 0
    }
}
