package de.novatec.studentservice.student

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "student")
data class StudentEntity(
        val id: String = UUID.randomUUID().toString(),
        val name: String
)

fun StudentEntity.toStudent(): Student {
    return Student(name)
}