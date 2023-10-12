package Teszt


//inherits from Employee
class Manager(name: String, employeeId: Int, salary: Double, val department: String) : Employee( name, employeeId, salary) {
    override fun displayInfo() {
        println("Manager:\n")
        super.displayInfo()
        println("Department: $department")
    }

}
