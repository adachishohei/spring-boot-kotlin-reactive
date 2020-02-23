package com.sabamiso.springbootkotlinreactive.infrastructure

import com.sabamiso.springbootkotlinreactive.domain.entity.Color
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.query.Criteria.where
import org.springframework.stereotype.Repository

/**
 *
 * @author adachishohei
 */
@Repository
class ColorRepository(private val databaseClient: DatabaseClient) {

  suspend fun findAll() = databaseClient.select().from(Color::class.java).fetch().all().asFlow()

  suspend fun findByCode(code: String): Color? {
    return databaseClient.select().from(Color::class.java).matching(where("code").`is`(code)).fetch().one()
      .awaitFirstOrNull()
  }

  suspend fun save(color: Color): Void? {
    return databaseClient.insert().into(Color::class.java).using(color).then().awaitFirstOrNull()
  }

  suspend fun deleteById(id: Int): Void? {
    return databaseClient.delete()
      .from(Color::class.java)
      .matching(where("id").`is`(id))
      .then().awaitFirstOrNull()
  }

}
