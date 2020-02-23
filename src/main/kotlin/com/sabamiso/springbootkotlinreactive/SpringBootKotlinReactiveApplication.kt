package com.sabamiso.springbootkotlinreactive

import com.sabamiso.springbootkotlinreactive.application.controller.ColorController
import com.sabamiso.springbootkotlinreactive.application.router.ReactiveApiRouter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans

@SpringBootApplication
class SpringBootKotlinReactiveApplication

fun main(args: Array<String>) {
  runApplication<SpringBootKotlinReactiveApplication>(*args) {
    addInitializers(ColorBean())
  }
}

fun ColorBean() = beans {
  bean<ReactiveApiRouter>()
  bean { ref<ReactiveApiRouter>().colorRouter() }
  bean<ColorController>()
}

