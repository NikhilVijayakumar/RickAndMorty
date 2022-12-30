package com.nikhil.xml.story.cleancode.builder

import com.nikhil.xml.story.cleancode.data.ModuleData
import com.squareup.kotlinpoet.*

class ModuleBuilder(val data:ModuleData) {
    val builder = TypeSpec.classBuilder(data.name)
    fun create():ModuleBuilder{
        builder
            .addAnnotation(data.module)
            .addAnnotation(
                AnnotationSpec.builder(data.installedIn)
                    .addMember("SingletonComponent::class")
                    .build()
            ).addModifiers(KModifier.ABSTRACT)
        return this
    }
    fun bindUseCase( ):ModuleBuilder{
       builder.addFunction(FunSpec.builder("bind${data.useCase.simpleName}")
           .addAnnotation(data.binds)
           .addModifiers(KModifier.ABSTRACT)
           .addParameter(
               ParameterSpec.builder(data.useCaseImpl.simpleName, data.useCaseImpl).build()
           )
           .returns(data.useCase)
           .build()
       )
        return this
    }

    fun bindRepo():ModuleBuilder{
        FunSpec.builder("bind${data.name}Repo")
        return this
    }

    fun bindLocalService():ModuleBuilder{
        FunSpec.builder("bind${data.name}LocalService")
        return this
    }

    fun bindRemoteService():ModuleBuilder{
        FunSpec.builder("bind${data.name}RemoteService")
        return this
    }

    fun build() = builder.build()

    /*
    *
    * import dagger.Binds.Binds
import dagger.Module.Module
import dagger.hilt.InstallIn.InstallIn
import dagger.hilt.components.SingletonComponent.SingletonComponent
    * */
    /* .addImport("dagger","Module")
          .addImport("dagger","Binds")
          .addImport("dagger.hilt","InstallIn")
          .addImport("dagger.hilt.components","SingletonComponent")
           .addImport(data.useCase.packageName,data.useCase.simpleName)
            .addImport(data.useCaseImpl.packageName,data.useCaseImpl.simpleName)

          */

    fun writeModule(type: TypeSpec) =
        FileSpec.builder(data.name.packageName, data.name.simpleName)
            .addType(type)
            .addImport(data.singletonComponent.packageName,data.singletonComponent.simpleName)
            .addFileComment("This is a generated file. Do not edit")
            .build()



}