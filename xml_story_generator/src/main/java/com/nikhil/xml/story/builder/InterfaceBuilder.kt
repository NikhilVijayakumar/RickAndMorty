package com.nikhil.xml.story.builder

import com.nikhil.xml.story.data.InterfaceData
import com.squareup.kotlinpoet.TypeSpec


class InterfaceBuilder(private val data: InterfaceData) {
    private val builder = TypeSpec.interfaceBuilder(data.name)
    fun create(): TypeSpec.Builder {
        data.propertyList.forEach { property ->
            builder.addProperty(property)
        }
        data.methodList.forEach { funData ->
            builder.addFunction(
                funData
            )
        }
        return builder
    }
}







