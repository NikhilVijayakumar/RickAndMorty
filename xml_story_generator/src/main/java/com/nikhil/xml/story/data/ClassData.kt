package com.nikhil.xml.story.data

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec

data class ClassData(
    val name: String,
    val constructorParameterList: List<ParameterSpec> = emptyList(),
    val propertyList: List<PropertySpec> = emptyList(),
    val modifierList: List<KModifier> = emptyList(),
    val methodList: List<FunSpec> = emptyList()
)