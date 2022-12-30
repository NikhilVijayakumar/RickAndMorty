package com.nikhil.xml.story.cleancode.builder

import com.nikhil.xml.story.base.builder.*
import com.nikhil.xml.story.base.data.ClassData
import com.nikhil.xml.story.base.data.InterfaceData
import com.nikhil.xml.story.base.data.MethodData
import com.nikhil.xml.story.base.data.PropertyData
import com.nikhil.xml.story.cleancode.data.RepoData
import com.squareup.kotlinpoet.*

class RepoBuilder(val data: RepoData) {
    fun createInterface(): TypeSpec {
        val modifierList: MutableList<KModifier> =
            mutableListOf(KModifier.ABSTRACT, KModifier.SUSPEND, KModifier.OPERATOR)

        val functionList: MutableList<FunSpec> = mutableListOf()
        val funData = MethodData(
            name = data.methodName,
            modifierList = modifierList

        )
        val returnType =   ClassName(data.dtoClass.packageName, data.dtoClass.simpleName)

        functionList.add(FunctionBuilder(funData).create().returns(returnType).build())

        val data = InterfaceData(
            name = data.repo.simpleName,
            methodList = functionList
        )
        return InterfaceBuilder(data).create().build()
    }


    /*fun createClass(): TypeSpec {

        val nameParameter = PropertyData("repo", data.repo)
        val parameterPair = getConstructorParameter(listOf(nameParameter))
        val classData = ClassData(
            name = "${data.useCase.simpleName}Impl",
            constructorParameterList = parameterPair.first,
            propertyList = parameterPair.second,
            methodList = getUseCaseMethod()
        )
        val superinterface =   ClassName(data.useCase.packageName, data.useCase.simpleName)

        return ClassBuilder(classData)
            .create()
            .addSuperinterface(superinterface)
            .build()
    }

    private fun getUseCaseMethod(): List<FunSpec> {
        val methodList: MutableList<FunSpec> = mutableListOf()
        val modifierList: MutableList<KModifier> = mutableListOf(
            KModifier.OVERRIDE,
            KModifier.SUSPEND,
            KModifier.OPERATOR)
        val methodData = MethodData(
            name = data.methodName,
            modifierList = modifierList,
        )
        val returnType =   ClassName(data.dtoClass.packageName, data.dtoClass.simpleName)

        methodList.add(
            FunctionBuilder(methodData)
                .create()
                .addStatement("repo()")
                .returns(returnType)
                .build()
        )
        return methodList

    }

    private  fun getConstructorParameter(data: List<PropertyData>): Pair<MutableList<ParameterSpec>, MutableList<PropertySpec>> {
        val constructorParameterList: MutableList<ParameterSpec> = mutableListOf()
        val propertyList: MutableList<PropertySpec> = mutableListOf()
        data.forEach { property ->
            constructorParameterList.add(
                ParameterBuilder(property).create().build()
            )
            propertyList.add(
                PropertyBuilder(property).create().build()
            )
        }
        return constructorParameterList to propertyList
    }*/

    fun writeInterface(type: TypeSpec, name:String) =
        writeToFile(type,name)
            .addImport(data.dtoClass.packageName,data.dtoClass.simpleName)
            .build()

    fun writeClass(type: TypeSpec, name:String) =
        writeToFile(type,name)
            .addImport(data.dtoClass.packageName,data.dtoClass.simpleName)
            .addImport(data.repo.packageName,data.repo.simpleName)
            .build()


    fun writeToFile(type: TypeSpec, name:String) =
        FileSpec.builder(data.repo.packageName, name)
            .addType(type)
            .addFileComment("This is a generated file. Do not edit")
}