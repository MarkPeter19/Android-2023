package Teszt

fun main() {
    val company = Company("ING BANK")
    company.addEmployee(Employee("Mark", 123, 1000.0))
    company.addEmployee(Employee("John", 456, 2000.0))
    company.addEmployee(Employee("Jane", 789, 3000.0))
    company.addEmployee(Manager("Tom", 101, 4000.0, "IT"))
    company.addEmployee(Manager("Kate", 102, 5000.0, "Finance"))

    company.displayEmployees()
    company.displayManagers()

    company.doubleSalaryOfManagers()

    //order the employees by name
    company.orderBy(OrderBy.NAME)

    //order the employees by salary
    company.orderBy(OrderBy.SALARY)

    //fire employee
    company.fireEmployee(101)
    company.displayEmployees()

}
