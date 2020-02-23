package com.sabamiso.springbootkotlinreactive.application.router

import com.sabamiso.springbootkotlinreactive.application.controller.ColorController
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

/**
 *
 * @author adachishohei
 */
class ReactiveApiRouter(private val colorController: ColorController) {
  @Bean
  fun colorRouter(): RouterFunction<ServerResponse> {
    return coRouter {
      ("/reactive/color" and accept(MediaType.APPLICATION_JSON)).nest {
        GET("/", colorController::getList)
        GET("/search", colorController::getByCode)
        POST("/", colorController::create)
        DELETE("/{id}", colorController::delete)
      }
    }
  }
}
