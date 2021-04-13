package example.controller

import com.google.gson.Gson
import org.springframework.web.bind.annotation.*

import example.model.Employee
import example.repository.EmployeeRepository

@RestController
class EmployeeController(
        private val employeesRepository: EmployeeRepository
) {

    @GetMapping("/employee")
    fun getAllEmployees(): String {
        val employees = employeesRepository.findAll()
        return Gson().toJson(employees).toString()
    }
}
