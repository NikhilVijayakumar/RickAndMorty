package com.nikhil.xml.story.base.data

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
import kotlin.reflect.KClass

data class PropertyData(
    val name: String,
    val type:ClassName,
    val modifierList: List<KModifier> = emptyList()
)
