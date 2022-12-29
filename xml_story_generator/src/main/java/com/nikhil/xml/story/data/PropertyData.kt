package com.nikhil.xml.story.data

import com.squareup.kotlinpoet.KModifier
import kotlin.reflect.KClass

data class PropertyData(
    val name: String,
    val type: KClass<*>,
    val modifierList: List<KModifier> = emptyList()
)
