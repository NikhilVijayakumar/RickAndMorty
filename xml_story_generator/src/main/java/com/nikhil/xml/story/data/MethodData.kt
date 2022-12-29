package com.nikhil.xml.story.data

import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec

data class MethodData(
    val name: String,
    val parameterList: List<ParameterSpec> = emptyList(),
    val modifierList: List<KModifier> = emptyList()
)