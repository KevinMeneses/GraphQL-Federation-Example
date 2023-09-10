package com.meneses.walks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WalksApplication

fun main(args: Array<String>) {
	runApplication<WalksApplication>(*args)
}
