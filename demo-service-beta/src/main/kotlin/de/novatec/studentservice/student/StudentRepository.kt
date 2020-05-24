package de.novatec.studentservice.student

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface StudentRepository : MongoRepository<StudentEntity, String> {

    @Query("{'name' : ?0}")
    fun findStudentEntityByName(name: String): StudentEntity?

}