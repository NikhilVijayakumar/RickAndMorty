package com.nikhil.xml.story.builder

import com.nikhil.xml.story.data.PropertyData
import com.squareup.kotlinpoet.ParameterSpec

class ParameterBuilder(private val data: PropertyData) {
    private val builder = ParameterSpec.builder(data.name, data.type)
    fun create(): ParameterSpec.Builder {
        data.modifierList.forEach { modifier ->
            builder.addModifiers(modifier)
        }
        return builder
    }
}