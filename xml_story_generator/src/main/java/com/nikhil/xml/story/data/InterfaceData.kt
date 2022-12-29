package com.nikhil.xml.story.data

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.PropertySpec

data class InterfaceData(
    val name: String,
    val propertyList: List<PropertySpec> = emptyList(),
    val methodList: List<FunSpec> = emptyList()
)