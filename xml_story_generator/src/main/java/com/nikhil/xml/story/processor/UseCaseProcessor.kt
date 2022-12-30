package com.nikhil.xml.story.processor

import com.google.auto.service.AutoService
import com.nikhil.xml.story.annotation.UseCase
import com.nikhil.xml.story.cleancode.builder.ModuleBuilder
import com.nikhil.xml.story.cleancode.builder.RepoBuilder
import com.nikhil.xml.story.cleancode.builder.UseCaseBuilder
import com.nikhil.xml.story.cleancode.data.ModuleData
import com.nikhil.xml.story.cleancode.data.RepoData
import com.nikhil.xml.story.cleancode.data.UseCaseData
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.DelicateKotlinPoetApi
import com.squareup.kotlinpoet.asClassName
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedOptions
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.lang.model.type.MirroredTypeException


@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_11)
@SupportedOptions(StoryProcessor.OPTION_NAME)
class UseCaseProcessor : StoryProcessor() {

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(UseCase::class.java.canonicalName)
    }

    override fun process(
        annotations: MutableSet<out TypeElement>?,
        roundEnv: RoundEnvironment?
    ): Boolean {
        if (roundEnv != null) {
            filterElements(roundEnv.getElementsAnnotatedWith(UseCase::class.java))
            return true
        }
        return false
    }

    @OptIn(DelicateKotlinPoetApi::class)
    private fun filterElements(elements: MutableSet<out Element>) {
        for (element in elements) {
            element.getAnnotationsByType(UseCase::class.java).map { usecase ->
                val dto = getClassValue(usecase)
                dto?.let { type ->
                    val dtoClass = type.asClassName()
                    generateCleanCode(
                        usecase.featureName,
                        usecase.rootPackageName,
                        usecase.featurePackageName,
                        dtoClass
                    )
                }

            }

        }

    }


    private fun getClassValue(useCase: UseCase): TypeElement? {
        try {
            useCase.dtoClass // this should throw
        } catch (mte: MirroredTypeException) {
            return processingEnv.typeUtils.asElement(mte.typeMirror) as TypeElement

        }
        return null // can this ever happen ??
    }

    private fun generateCleanCode(
        featureName: String,
        rootPackageName: String,
        featurePackageName: String,
        dtoClass: ClassName
    ) {
        val useCasePackageName = "$rootPackageName.domain.$featurePackageName"
        val repoPackageName = "$rootPackageName.data.repo.$featurePackageName"
        val diPackageName = "$rootPackageName.di.$featurePackageName"

        val useCase =   ClassName(useCasePackageName, "${featureName}UseCase")
        val repo =    ClassName(repoPackageName, "${featureName}Repo")

        val useCaseData = UseCaseData(
            useCase = useCase,
           repo = repo,
            dtoClass = dtoClass
        )

        val repoData = RepoData(
            repo = repo,
            dtoClass = dtoClass
        )

        val moduleData = ModuleData(
            name = ClassName(diPackageName,"${featureName}Module"),
         module = ClassName("dagger","Module"),
         installedIn= ClassName("dagger.hilt","InstallIn"),
         singletonComponent= ClassName("dagger.hilt.components","SingletonComponent"),
         binds= ClassName("dagger","Binds"),
        useCase = useCase,
            useCaseImpl = ClassName(useCasePackageName, "${featureName}UseCaseImpl")
        )



        val  repoBuilder = RepoBuilder(repoData)
        repoBuilder.writeInterface(repoBuilder.createInterface(),"${featureName}Repo")
            .writeTo(getRootFile())

        val useCaseBuilder = UseCaseBuilder(useCaseData)
        useCaseBuilder.writeInterface(useCaseBuilder.createInterface(),"${featureName}UseCase")
            .writeTo(getRootFile())

        useCaseBuilder.writeClass(useCaseBuilder.createClass(),"${featureName}UseCaseImpl")
            .writeTo(getRootFile())

        val  moduleBuilder = ModuleBuilder(moduleData)
        moduleBuilder.writeModule( moduleBuilder.create()
                .bindUseCase()
                .build())
            .writeTo(getRootFile())

    }


}