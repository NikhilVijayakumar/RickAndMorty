package com.nikhil.xml.story.base.builder

import com.nikhil.xml.story.base.data.ClassData
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import javax.inject.Inject
import kotlin.reflect.KClass

class ClassBuilder(private val data: ClassData) {
    val builder = TypeSpec.classBuilder(data.name)

    fun addAnnotation(annotation: KClass<*>):ClassBuilder {
        builder.addAnnotation(annotation)
        return this
    }

    fun addAnnotation(annotation: AnnotationSpec):ClassBuilder {
        builder.addAnnotation(annotation)
        return this
    }

    fun inject(): ClassBuilder{
        if (data.constructorParameterList.isNotEmpty()) {
            val constructorBuilder = FunSpec.constructorBuilder()
            constructorBuilder.addAnnotation(Inject::class)
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
        return this
    }


    fun create(): ClassBuilder {
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

        return this
    }


}