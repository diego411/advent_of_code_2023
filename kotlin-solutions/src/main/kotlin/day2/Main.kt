package day2

import java.io.File

const val N_RED = 12
const val N_GREEN = 13
const val N_BLUE = 14

fun main() {
    var sum = 0
    var powerSum = 0
    File("./src/main/kotlin/day2/input.txt").forEachLine {
        val split = it.split(':')
        val id = split[0].split(' ')[1]
        val games = split[1].split(';')

        var maxRed = 0
        var maxGreen = 0
        var maxBlue = 0
        for (game in games) {
            val draws = game.split(',')
            for (draw in draws) {
                val drawSplit = draw.split(' ')
                val number = drawSplit[1].toInt()
                val color = drawSplit[2]

                when (color) {
                    "red" -> maxRed = if (number > maxRed) number else maxRed
                    "green" -> maxGreen = if (number > maxGreen) number else maxGreen
                    "blue" -> maxBlue = if (number > maxBlue) number else maxBlue
                }
            }
        }

        if (maxRed <= N_RED && maxGreen <= N_GREEN && maxBlue <= N_BLUE)
            sum += id.toInt()

        var power = maxRed * maxGreen * maxBlue
        powerSum += power
    }

    println("Sum: $sum")
    println("Power sum: $powerSum")
}