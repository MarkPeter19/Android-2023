package main.Date

import java.time.LocalDate
import java.util.Calendar
import kotlin.random.Random


fun main(){
    val date = Date()
    println(date)
    println(date.isleapYear())
    println(date.isValidDate())

    val date1 = Date(2023, 2, 29)
    println(date1.isValidDate())

    val random = Random.Default
    val validDates = mutableListOf<Date>()


    while(validDates.size < 10){
        val randomDate = generateRandomDate(random)
        if(randomDate.isValidDate()){
            validDates.add(randomDate)
        }else{
            println("Invalid date: $randomDate")
        }
    }

    println("Valid Dates:")
    validDates.forEach { println(it) }

    //natural ordering (Comparable interface)
    validDates.sort()

    println("\nSorted Dates:")
    validDates.forEach { println(it) }

    validDates.reverse()

    println("\nReversed Dates:")
    validDates.forEach { println(it) }

    //custom ordering (comparator)
    //napok szerint
    validDates.sortWith(customComparator)
    println("\nCustom Sort by Days:")
    validDates.forEach { println(it) }

}

fun generateRandomDate(random: Random): Date {
    val year = random.nextInt(2000, 2100)
    val month = random.nextInt(1, 13)
    val day = random.nextInt(1, 32)
    return Date(year, month, day)
}

// napok szerint
val customComparator = Comparator { date1: Date, date2: Date ->
    if (date1.day != date2.day) {
        date1.day - date2.day
    } else if (date1.month != date2.month) {
        date1.month - date2.month
    } else {
        date1.year - date2.year
    }
}

