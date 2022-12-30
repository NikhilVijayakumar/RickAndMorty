package com.nikhil.xml.story.cleancode.data

import com.squareup.kotlinpoet.ClassName

data class ModuleData(val name:ClassName,
                      val module: ClassName,
                      val installedIn: ClassName,
                      val singletonComponent:ClassName,
                      val binds:ClassName,
                      val useCase: ClassName,
                      val useCaseImpl: ClassName
                      )