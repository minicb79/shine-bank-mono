package com.shine.bank.monobank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MonoBankApplication

fun main(args: Array<String>) {
	runApplication<MonoBankApplication>(*args)
}
