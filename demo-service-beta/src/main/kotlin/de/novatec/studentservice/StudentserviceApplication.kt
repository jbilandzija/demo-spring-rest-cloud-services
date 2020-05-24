package de.novatec.studentservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class StudentserviceApplication

fun main(args: Array<String>) {
	runApplication<StudentserviceApplication>(*args)
}
