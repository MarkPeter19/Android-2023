package main.Date

import java.time.LocalDate


data class Date (
    val year: Int = LocalDate.now().year,
    val month: Int = LocalDate.now().monthValue,
    val day: Int = LocalDate.now().dayOfMonth
): Comparable<Date>{
    override fun compareTo(other: Date): Int {
        if(this.year != other.year){
            return year - other.year
        }else if(this.month != other.month){
            return month - other.month
        }

        return day - other.day

    }
}

fun Date.isleapYear(): Boolean {
    return this.year % 4 == 0 && (this.year % 100 != 0 || this.year % 400 == 0)
}

fun Date.isValidDate(): Boolean{
    if (year < 1 || month < 1 || month > 12 || day < 1 ) return false

    val daysInMonth = when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> if (isleapYear()) 29 else 28
        else -> return false
    }

    return day <= daysInMonth
}


