package de.novatec.studentservice.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/student")
@CrossOrigin(origins = [], allowCredentials = "false", allowedHeaders = ["*"], methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE])
class StudentController(private val studentRepository: StudentRepository) {

    @GetMapping("/{name}")
    fun getStudentByName(@PathVariable("name") name: String): ResponseEntity<Student> {
        val result = studentRepository.findStudentEntityByName(name)?.toStudent()
        return if (result == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(result)
        }
    }

    @DeleteMapping("/{name}")
    fun deleteStudentByName(@PathVariable("name") name: String): ResponseEntity<String> {
        val result = studentRepository.findStudentEntityByName(name)
        if (result != null) {
            studentRepository.delete(result)
        }
        return ResponseEntity.ok(name)
    }

    @PostMapping
    fun postStudentByName(@RequestBody student: Student): ResponseEntity<Student> {
        val result = studentRepository.findStudentEntityByName(student.name)
        val temp = if (result == null) {
            studentRepository.save(StudentEntity(UUID.randomUUID().toString(), student.name))
        } else {
            studentRepository.save(StudentEntity(result.id, student.name))
        }
        return ResponseEntity.ok(temp.toStudent())
    }

    @GetMapping
    fun getAllCocktailIngredients(): ResponseEntity<List<Student>> {
        println("Get All")
        return ResponseEntity.ok(studentRepository.findAll().map { it.toStudent() })
    }
}
