package day1

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val path = System.getProperty("user.dir")
    println("Working Directory = $path")
    var sum = 0
    File("./src/main/kotlin/day1/input.txt").forEachLine {
        val (first, last) = getFirstAndLastNumber(it)
        if (first == null || last == null)
            throw IllegalArgumentException("Line did not contain a digit")

        val calibrationValue = "" + first + last
        sum += calibrationValue.toInt()
    }

    println(sum)
}

fun getFirstAndLastNumber(str: String): Pair<Char?, Char?> {
    var first: Char? = null
    var last: Char? = null
    for (c: Char in str) {
        if (c.isDigit()) {
            first = first ?: c
            last = c
        }
    }

    return Pair(first, last)
}