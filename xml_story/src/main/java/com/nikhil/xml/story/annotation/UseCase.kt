package com.nikhil.xml.story.annotation

import java.util.Objects
import javax.lang.model.element.TypeElement
import kotlin.reflect.KClass

@Retention(AnnotationRetention.SOURCE)
@Target(
    AnnotationTarget.CLASS
)
annotation class UseCase(
    val dtoClass: KClass<out Any>,
    val featureName: String = "Sample",
    val rootPackageName: String = "com.example",
    val featurePackageName: String = "sample",


    )