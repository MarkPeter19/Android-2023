package test

import java.beans.Encoder
import java.util.*

fun main(){

    //1. fd
    //sumOfTwoNumbers(number1, number2)
    //2. fd
    //workWithLists()
    //3.fd
    //println(isPrime(21))
    //4. fd
    //val codedMessage = messageCoding("laskaleves ✨", ::EncoderBase64)
    //println(codedMessage)
    //val decodedMessage = messageCoding(codedMessage, ::decoderBase64)
    //println(decodedMessage)
    // 5. fd
    //var numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    //printEvenNumbersFromList(numberList)
    // 6. fd
    //workWithMap()
    // 7. fd
    //workWithMutableLists()
    // 8. fd
    workWithArrays()

}

// print the addition of two numbers
fun  sumOfTwoNumbers( number1: Int, number2: Int){
    println("$number1 + $number2 = ${number1 + number2}")
}

fun workWithLists(){
    println("\nExercise 2")
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    // Use a for loop that iterates over the list and prints the list to the standard output
//    for (day in daysOfWeek){
//        println(day)
//    }

    daysOfWeek.forEach{ day -> println(day) }

    //Use a list filter to print the days starting with letter ‘T’
    println("\nExercise 2.1")
    daysOfWeek.filter { it.startsWith("T") }.forEach { println(it) }
    //Use a list filter to print the days containing the letter ‘e’
    println("\nExercise 2.2")
    daysOfWeek.filter { it.contains("e") }.forEach { println(it) }
    //Use a list filter to print all the days of length 6 (e.g. Friday)

    println("\nExercise 2.3")
    daysOfWeek.filter { it.length == 6 }.forEach { println(it) }

}

//Write a function that checks whether a number is prime or not. Write a main function that
//prints prime numbers within a range.

fun isPrime(number: Int): Boolean{
    for (i in 2..number/2){
        if (number % i == 0){
            return false
        }
    }
    return true
}

//4. Write an encode and a corresponding decode function that encodes and respectively
//decodes the characters of a string. You may use any encoding strategy.
//● Test your functions!
//● Write a higher-order function (take a function as parameter) that encodes or decodes a
//message. Call this function twice. Once for encoding and once for decoding a message.
fun messageCoding(msg: String, func: (String) -> String) = func(msg)


fun EncoderBase64(msg: String):String{
    return Base64.getEncoder().encodeToString(msg.toByteArray())
}

fun decoderBase64(msg: String):String{
    return String(Base64.getDecoder().decode(msg))
}

//5. Write a compact function that prints the even numbers from a list. Use a list filter!

fun printEvenNumbersFromList(numberList: List<Int>): Unit = println(numberList.filter { it % 2 == 0 })

//6.

fun workWithMap(){
    var numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("\nExercise 6.1")
    //Double the elements of a list of integers and print it
    //println(numbers.map { it * 2 })
    numbers.map { it * 2 }.also { println(it) }
    //numbers.map({ it * 2 }).forEach { print(" $it") }

    println("\nExercise 6.2")
    var daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    //Print the days of week capitalized (e.g. MONDAY for Monday)
    println(daysOfWeek.map { it.uppercase() })

    println("\nExercise 6.3")
    //Print the first character of each day capitalized (e.g. m for Monday)
    println(daysOfWeek.map { it.first().uppercaseChar() })

    println("\nExercise 6.4")
    //Print the length of days (number of characters, e.g. Monday → 6)
    daysOfWeek.map { it.length }.also { println(it) }

    println("\nExercise 6.5")
    //Compute the average length of days (in number of characters)
    var averageLength = daysOfWeek.map { it.length }.average()
    println(averageLength)

}

fun workWithMutableLists(){
    println("\nExercise 7.1")
    //Convert the daysOfWeek immutable list into a mutable one. Remove all days containing
    //the letter ‘n’, then print the mutable list. You should get this result:
    //[Tuesday, Thursday, Friday, Saturday]
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val mutableDaysOfWeek = daysOfWeek.toMutableList()
    mutableDaysOfWeek.removeAll { it.contains("n") }
    println(mutableDaysOfWeek)

    println("\nExercise 7.2")
    //Print each element of the list in a new line together with the index of the element (convert
    //the list to list with index using the withIndex() function!). You should get the following
    //result:
    //Item at 0 is Tuesday
    //Item at 1 is Thursday
    //Item at 2 is Friday
    //Item at 3 is Saturday
    mutableDaysOfWeek.withIndex().forEach { println("Item at ${it.index} is ${it.value}") }

    println("\nExercise 7.3")
    //sort
    mutableDaysOfWeek.sort()
    println(mutableDaysOfWeek)

}

fun workWithArrays(){
    println("\nExercise 8.1")
    //Generate an array of 10 random integers between 0 and 100, and use forEach to print
    //each element of the array in a new line.
    val randomNumbers = Array(10) { Random().nextInt(100) }
    randomNumbers.forEach { println(it) }

    println("\nExercise 8.2")
    //array sorted in ascending order
    randomNumbers.sort()
    randomNumbers.forEach { println(it) }

    println("\nExercise 8.3")
    //Check whether the array contains any even number!
    println(randomNumbers.any { it % 2 == 0 })

    println("\nExercise 8.4")
    //Check whether all the numbers are even!
    println(randomNumbers.all { it % 2 == 0 })

    println("\nExercise 8.5")
    //Calculate the average of generated numbers and print it using forEach!
    var sum = 0.00
    randomNumbers.forEach { sum += it }
    println(sum / randomNumbers.size)


}


