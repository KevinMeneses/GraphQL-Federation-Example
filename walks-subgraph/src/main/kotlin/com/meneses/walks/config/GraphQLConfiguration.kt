package com.meneses.walks.config

import com.apollographql.federation.graphqljava.Federation
import com.apollographql.federation.graphqljava._Entity
import com.meneses.walks.model.PET_TYPE
import com.meneses.walks.model.Pet
import graphql.schema.DataFetcher
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.ClassNameTypeResolver


@Configuration
class GraphQLConfiguration {
    @Bean
    fun federationTransform(): GraphQlSourceBuilderCustomizer? {
        val entityDataFetcher: DataFetcher<*> = DataFetcher<Any> { env ->
            val representations = env.getArgument<List<Map<String, Any>>>(_Entity.argumentName)
            representations.map { representation ->
                if (PET_TYPE != representation["__typename"]) return@map null
                val walksIds = (representation["walksIds"] as? List<*>)?.map { it.toString().toInt() }?.toSet() ?: emptySet()
                Pet(walksIds)
            }
        }

        return GraphQlSourceBuilderCustomizer { builder ->
            builder.schemaFactory { registry, wiring ->
                Federation.transform(registry, wiring)
                    .fetchEntities(entityDataFetcher)
                    .resolveEntityType(ClassNameTypeResolver())
                    .build()
            }
        }
    }
}