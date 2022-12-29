package com.nikhil.xml.story.processor

import java.io.File
import javax.annotation.processing.AbstractProcessor

abstract class StoryProcessor : AbstractProcessor() {
    companion object {
        const val OPTION_NAME = "kapt.kotlin.generated"
    }

    protected fun getRootFile(): File {
        val file = File(getGeneratedSourcesRoot())
        file.mkdir()
        return file
    }

    private fun getGeneratedSourcesRoot(): String {
        val generatedSourcesRoot: String = processingEnv.options[OPTION_NAME].orEmpty()
        if (generatedSourcesRoot.isEmpty()) {
            errorMessage("Can't find the target directory for generated Kotlin files.")
        }
        return generatedSourcesRoot
    }

    protected fun errorMessage(message: String) {
        processingEnv.messager.printMessage(javax.tools.Diagnostic.Kind.ERROR, message)
    }

    protected fun noteMessage(message: String) {
        processingEnv.messager.printMessage(javax.tools.Diagnostic.Kind.NOTE, message)
    }

    protected fun warningMessage(message: String) {
        processingEnv.messager.printMessage(javax.tools.Diagnostic.Kind.WARNING, message)
    }
}