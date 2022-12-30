package com.nikhil.xml.story.cleancode.data

import com.squareup.kotlinpoet.ClassName


data class UseCaseData(
    val useCase: ClassName,
    val dtoClass: ClassName,
    val repo:ClassName,
    val methodName:String = "invoke"
)