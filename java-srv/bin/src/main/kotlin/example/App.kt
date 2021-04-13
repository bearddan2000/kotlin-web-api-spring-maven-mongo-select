package example;

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.runApplication
import example.repository.EmployeeRepository
import example.model.*

@SpringBootApplication
class Application(private val employeesRepository: EmployeeRepository)
: ApplicationRunner {
	override fun run(args: ApplicationArguments?) {
		val ct :Int = employeesRepository.findAll().count()
		if(ct < 1 || ct > 5) {
			clearAll()
			seedCollection()
		}
	}

	fun clearAll()
	{
		employeesRepository.deleteAll()
	}

	fun seedCollection(){
		val mgr :Manager = Manager(
	   first_name = "Jane",
	   last_name = "Doe")

		val employee :Employee = Employee(
	   first_name = "John",
	   last_name = "Doe",
	   title = "Contractor",
	   years_of_service = 1,
	   skills = arrayOf("Java"),
		 manager = mgr)

		employeesRepository.insert(employee)
	}

}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
