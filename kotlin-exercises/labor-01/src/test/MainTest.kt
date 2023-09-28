package test

import java.beans.Encoder
import java.util.Base64

fun main(){
    var name = "Peter"
    name = "Pablo"

    val number1 = 10
    val number2 = 20
    //sumOfTwoNumbers(number1, number2)
    workWithLists()
    //println(isPrime(21))
    //Exercise 4
    //val codedMessage = messageCoding("Hello World!", ::EncoderBase64)
    val decodedMessage = decoderBase64("bGFza2FsZXZlcyDinKg=")
    //println(codedMessage)
    println(decodedMessage)
}

// print the addition of two numbers
fun  sumOfTwoNumbers( number1: Int, number2: Int){
    println("$number1 + $number2 = ${number1 + number2}")
}

fun workWithLists(){
    println("\nExercise 1")
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






