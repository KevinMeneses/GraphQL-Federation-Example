package com.meneses.pets.config

import com.apollographql.federation.graphqljava.Federation
import com.apollographql.federation.graphqljava._Entity
import com.meneses.pets.model.OWNER_TYPE
import com.meneses.pets.model.Owner
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
                if (OWNER_TYPE != representation["__typename"]) return@map null
                val petsIds = (representation["petsIds"] as? List<*>)?.map { it.toString().toInt() }?.toSet() ?: emptySet()
                Owner(petsIds)
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