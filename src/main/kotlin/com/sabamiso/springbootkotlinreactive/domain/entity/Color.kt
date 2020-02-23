package com.sabamiso.springbootkotlinreactive.domain.entity

import com.sabamiso.springbootkotlinreactive.domain.dto.ColorRequest
import org.springframework.data.annotation.Id

/**
 *
 * @author adachishohei
 */
class Color(
  @Id
  val id: Int = 0,
  val name: String,
  val code: String
) {
  constructor(colorRequest: ColorRequest) : this(
    name = colorRequest.name,
    code = colorRequest.code
  )
}
