package com.meneses.owners

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OwnersApplication

fun main(args: Array<String>) {
	runApplication<OwnersApplication>(*args)
}
