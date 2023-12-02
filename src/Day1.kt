package advent.of.code

import java.io.File

fun calibration(line: String): Int {
    val str = (line.find { it.isDigit() }?.toString() ?: "") + (line.findLast { it.isDigit() }?.toString() ?: "")
    return str.toIntOrNull() ?: 0
}

fun calibration2(line: String): Int {
    val numbersMap1 = mapOf("twone" to "2", "one" to "1", "two" to "2", "three" to "3", "four" to "4", "five" to "5", "six" to "6", "seven" to "7", "eight" to "8", "nine" to "9")
    val numbersMap2 = mapOf("twone" to "1", "one" to "1", "two" to "2", "three" to "3", "four" to "4", "five" to "5", "six" to "6", "seven" to "7", "eight" to "8", "nine" to "9")
    val reg = Regex("twone|one|two|three|four|five|six|seven|eight|nine|[1-9]")
    fun String.fromMap1() = numbersMap1.getOrDefault(this, this)
    fun String.fromMap2() = numbersMap2.getOrDefault(this, this)
    return ((reg.find(line)?.value?.fromMap1()?:"") + (reg.findAll(line).lastOrNull()?.value?.fromMap2()?:"")).toIntOrNull()?:0
}

fun first(fileName: String) {
    var totalCalibration = 0
    File(fileName).forEachLine {
        totalCalibration += calibration(it)
    }
    println(totalCalibration)
}

fun second(fileName: String) {
    var totalCalibration: Long = 0
    File(fileName).forEachLine {
        println(calibration2(it))
        totalCalibration += calibration2(it)
    }
    println(totalCalibration)
}

fun main(input: Array<String>) {
    val fileName = input[0]
//    first(fileName)
    second(fileName)
}