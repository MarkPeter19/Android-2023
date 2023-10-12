package Teszt

class Company(val name:String) {
    val employees = mutableListOf<Employee>()

    fun addEmployee(employee: Employee): Boolean {
        if (employees.contains(employee)) {
            return false
        } else {
            employees.add(employee)
            return true
        }
    }

    fun displayEmployees(): Unit {
        employees.forEach { it.displayInfo() }
    }

    fun displayManagers(): Unit{
        employees.filter { it is Manager }.forEach { it.displayInfo() }
    }

    fun doubleSalaryOfManagers(){
        employees.filter { it is Manager }.map { it.salary * 2 }.also { println(it) }
    }

    fun fireEmployee(id: Int): Boolean {
        if (employees.removeIf { it.employeeId == id }) {
            return true
        } else {
            return false
        }
    }

    fun orderBy(criteria: OrderBy): Unit {
        when (criteria) {
            OrderBy.NAME -> employees.sortBy { it.name }
            OrderBy.SALARY -> employees.sortBy { it.salary }
        }
    }

}
