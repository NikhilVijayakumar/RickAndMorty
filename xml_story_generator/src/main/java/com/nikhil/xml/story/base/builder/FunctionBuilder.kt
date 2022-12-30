package com.nikhil.xml.story.base.builder

import com.nikhil.xml.story.base.data.MethodData
import com.squareup.kotlinpoet.FunSpec

class FunctionBuilder(private val data: MethodData) {
    private val builder = FunSpec.builder(data.name)

    fun create(): FunSpec.Builder {
        data.parameterList.forEach { parameter ->
            builder.addParameter(parameter)
        }
        data.modifierList.forEach { modifier ->
            builder.addModifiers(modifier)
        }
        return builder
    }
}

