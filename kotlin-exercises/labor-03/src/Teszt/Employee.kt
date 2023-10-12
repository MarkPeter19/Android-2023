package Teszt


//make sure that the ID of each employee is unique
open class Employee(val name: String, val employeeId: Int, var salary : Double) {

    fun getSalary(): Double {
        return this.salary
    }

    fun setSalary(newSalary: Double){
        this.salary = newSalary
        println("$name's new salary: $salary")
    }

    open fun displayInfo(){
        println("Name: $name")
        println("Employee ID: $employeeId")
        println("Salary: $salary")
    }

}