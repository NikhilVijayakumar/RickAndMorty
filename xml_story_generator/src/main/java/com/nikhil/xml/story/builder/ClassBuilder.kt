package com.nikhil.xml.story.builder

import com.nikhil.xml.story.data.ClassData
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec

class ClassBuilder(private val data: ClassData) {
    private val builder = TypeSpec.classBuilder(data.name)
    fun create(): TypeSpec.Builder {
        if (data.constructorParameterList.isNotEmpty()) {
            val constructorBuilder = FunSpec.constructorBuilder()
            data.constructorParameterList.forEach { parameter ->
                constructorBuilder
                    .addParameter(parameter)
            }
            builder.primaryConstructor(constructorBuilder.build())
        }
        data.propertyList.forEach { property ->
            builder
                .addProperty(property)
        }

        data.methodList.forEach { method ->
            builder.addFunction(method)
        }

        data.modifierList.forEach { modifier ->
            builder.addModifiers(modifier)
        }

        return builder
    }
}