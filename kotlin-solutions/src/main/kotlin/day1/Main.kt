package day1

import java.io.File

fun main() {
    var sum = 0
    File("./src/main/kotlin/day1/input.txt").forEachLine {
        val code = replaceCharNumbers(it)
        val (first, last) = getFirstAndLastNumber(code)
        if (first == null || last == null)
            throw IllegalArgumentException("Line did not contain a digit")
        val calibrationValue = "" + first + last
        sum += calibrationValue.toInt()
    }

    println(sum)
}

fun replaceCharNumbers(str: String): String {
    var out = str.replace("one", "o1e")
    out = out.replace("two", "t2o")
    out = out.replace("three", "t3e")
    out = out.replace("four", "f4r")
    out = out.replace("five", "f5e")
    out = out.replace("six", "s6x")
    out = out.replace("seven", "s7n")
    out = out.replace("eight", "e8t")
    out = out.replace("nine", "m9e")

    return out
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