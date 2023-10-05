package main.Extensions

fun main( args: Array<String> ) {
    val name = "Mark Peter"
    println(name.monogram())

    val words = listOf("apple", "pear", "orange")
    println(words.joinBySeparator("#"))

    println(words.longestString())
}

fun List<String>.longestString() = sortedBy { it.length }.last()
fun List<String>.joinBySeparator(separator: String) = this.joinToString(separator)
fun String.monogram() = split(" ")
    .map { it.first() }
    .joinToString("")