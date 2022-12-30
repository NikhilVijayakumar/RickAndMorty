package com.nikhil.xml.story.base.builder

import com.nikhil.xml.story.base.data.PropertyData
import com.squareup.kotlinpoet.PropertySpec

class PropertyBuilder(private val data: PropertyData) {
    private val builder = PropertySpec.builder(data.name, data.type)
    fun create(): PropertySpec.Builder {
        data.modifierList.forEach { modifier ->
            builder.addModifiers(modifier)
        }
        return builder
    }
}



