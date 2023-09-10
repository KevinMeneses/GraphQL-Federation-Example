package com.meneses.owners.config

import com.apollographql.federation.graphqljava.Federation
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class GraphQLConfiguration {

    @Bean
    fun federationTransform(): GraphQlSourceBuilderCustomizer? {
        return GraphQlSourceBuilderCustomizer { builder ->
            builder.schemaFactory { registry, wiring ->
                Federation.transform(registry, wiring)
                    .fetchEntities { null }
                    .resolveEntityType { null }
                    .build()
            }
        }
    }
}