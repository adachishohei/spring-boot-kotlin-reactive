package com.sabamiso.springbootkotlinreactive.application.controller

import com.sabamiso.springbootkotlinreactive.domain.dto.ColorRequest
import com.sabamiso.springbootkotlinreactive.domain.service.ColorService
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.bodyValueAndAwait

/**
 *
 * @author adachishohei
 */
@Component
class ColorController(private val colorService: ColorService) {

  suspend fun getList(request: ServerRequest): ServerResponse {
    return ServerResponse.ok().bodyAndAwait(colorService.findAll())
  }

  suspend fun getByCode(request: ServerRequest): ServerResponse {
    val code = request.queryParam("code").orElseThrow { throw RuntimeException("codeがありません") }
    return ServerResponse.ok().bodyValueAndAwait(
      colorService.findByCode(code = code) ?: throw RuntimeException
        ("見つかりませんでした")
    )
  }

  suspend fun create(request: ServerRequest): ServerResponse {
    val colorRequest = request.bodyToMono(ColorRequest::class.java).awaitFirst()
    colorService.create(colorRequest)
    return ServerResponse.status(HttpStatus.OK).bodyValueAndAwait("OK")
  }

  suspend fun delete(request: ServerRequest): ServerResponse {
    val id = request.pathVariable("id")
    colorService.delete(id.toInt())
    return ServerResponse.status(HttpStatus.OK).bodyValueAndAwait("OK")
  }

}
