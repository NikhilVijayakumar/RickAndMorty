package com.nikhil.xml.story.annotation

import kotlin.reflect.KClass

@Retention(AnnotationRetention.SOURCE)
@Target(
    AnnotationTarget.CLASS
)
annotation class UseCase(
    val featureName: String = "Usecase",
    val packageName: String = "Usecase",
    val dtoClass: KClass<Any> = Any::class
)