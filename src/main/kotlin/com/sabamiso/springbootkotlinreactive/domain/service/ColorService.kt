package com.sabamiso.springbootkotlinreactive.domain.service

import com.sabamiso.springbootkotlinreactive.domain.dto.ColorRequest
import com.sabamiso.springbootkotlinreactive.domain.entity.Color
import com.sabamiso.springbootkotlinreactive.infrastructure.ColorRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

/**
 *
 * @author adachishohei
 */
@Service
class ColorService(private val colorRepository: ColorRepository) {

  suspend fun findAll(): Flow<Color> {
    return colorRepository.findAll()
  }

  suspend fun findByCode(code: String): Color? {
    return colorRepository.findByCode(code)
  }

  suspend fun create(colorRequest: ColorRequest): Void? {
    return colorRepository.save(Color(colorRequest))
  }

  suspend fun delete(id: Int): Void? {
    return colorRepository.deleteById(id)
  }
}
