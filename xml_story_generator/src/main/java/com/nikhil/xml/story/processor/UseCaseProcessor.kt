package com.nikhil.xml.story.processor

import com.google.auto.service.AutoService
import com.nikhil.xml.story.annotation.UseCase
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedOptions
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement

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

    private fun filterElements(elements: MutableSet<out Element>) {
        for (element in elements) {
          element.getAnnotationsByType(UseCase::class.java).map {
             val featureName = it.featureName
              val packagename = it.packageName
              val dto = it.dtoClass

          }

        }

    }
}