package com.nikhil.xml.story.generator

import com.google.auto.service.AutoService
import com.nikhil.xml.story.annotation.AutoMap
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import java.io.File
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement

@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedOptions(AutoMapGenerator.OPTION_NAME)
class AutoMapGenerator : AbstractProcessor() {

    companion object {
        const val OPTION_NAME = "kapt.kotlin.generated"
    }

    private fun getRootFile(): File {
        val file = File(getGeneratedSourcesRoot())
        file.mkdir()
        return file
    }



    private fun getGeneratedSourcesRoot(): String {
        val generatedSourcesRoot: String = processingEnv.options[OPTION_NAME].orEmpty()
        if (generatedSourcesRoot.isEmpty()) {
            processingEnv.messager.errormessage { "Can't find the target directory for generated Kotlin files." }
        }
        return generatedSourcesRoot
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(AutoMap::class.java.canonicalName)
    }


    override fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
        filterModules(roundEnv.getElementsAnnotatedWith(AutoMap::class.java))
        return true
    }

    private fun filterModules(elements: MutableSet<out Element>) {
        for (element in elements) {
            if (element !is TypeElement) {
                processingEnv.messager.errormessage { "Not a class" }
                continue
            }
            val variable: List<Pair<String, TypeElement?>> = element.enclosedElements
                .filterIsInstance<VariableElement>()
                .map { variable ->
                    val varType: TypeElement =
                        processingEnv.typeUtils.asElement(variable.asType()) as TypeElement
                    val hasAnnotation: Boolean = varType.getAnnotation(AutoMap::class.java) != null
                    variable.simpleName.toString() to varType.takeIf { hasAnnotation }
                }
            generateCode(element, variable)
        }

    }

    @OptIn(DelicateKotlinPoetApi::class)
    private fun generateCode(element: TypeElement, variable: List<Pair<String, TypeElement?>>) {
        val returnType: ParameterizedTypeName = ClassName("kotlin.collections", "Map")
            .plusParameter(String::class.asTypeName())
            .plusParameter(Any::class.asTypeName().copy(nullable = true))
        val mapOfFunction = MemberName("kotlin.collections", "mapOf")

        val codeBlockBuilder: CodeBlock.Builder = CodeBlock.builder()
            .addStatement("val map: %T = %M(", returnType, mapOfFunction)
            .indent()

        variable.forEachIndexed { index: Int, (name: String, varType: TypeElement?) ->
            val comma = if (index < variable.size - 1) "," else ""
            if (varType != null) {
                val toMap = MemberName(varType.asClassName().packageName, "toMap")
                codeBlockBuilder.addStatement("%S to %L.%M()%L", name, name, toMap, comma)
            } else {
                codeBlockBuilder.addStatement("%S to %L%L", name, name, comma)
            }
        }
        codeBlockBuilder.unindent()
            .addStatement(")")
            .addStatement("return map")

        val className = ClassName(element.asClassName().packageName, element.simpleName.toString())
        val mapClass = ClassName("kotlin.collections", "Map")

        val funSpec = FunSpec.builder("toMap")
            .receiver(className)
            .returns(returnType)
            .addKdoc("Convert [%T] to [%T].", className, mapClass)
            .addCode(codeBlockBuilder.build())
            .build()

        FileSpec.builder(className.packageName, "${className.simpleName}MapGenerated")
            .addFunction(funSpec)
            .addFileComment("This is a generated file. Do not edit")
            .build()
            .writeTo(getRootFile())

    }
}

