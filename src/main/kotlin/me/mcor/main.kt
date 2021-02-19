package me.mcor

import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
}

private const val OPEN: Char = '('
private const val CLOSE: Char = ')'

fun balanceBrackets(input: String): String {
    val openParenStack = Stack<Int>()
    val parenPairStack = Stack<Pair<Int, Int>>()
    // fix all the idx of pair
    input.forEachIndexed { i, char ->
        when (char) {
            OPEN -> {
                openParenStack.push(i)
            }
            CLOSE -> {
                if (!openParenStack.isEmpty()) {
                    val openIdx = openParenStack.pop()
                    parenPairStack.push(Pair(openIdx, i))
                }
            }
            else -> {
                // skip
            }
        }
    }
    // result is all char with '(' and ')' removed
    val result = input.map {
        if (it != OPEN && it != CLOSE) it else ""
    }.toMutableList()
    // insert back the '(' and ')'
    parenPairStack.forEach { (startIdx, endIdx) ->
        result[startIdx] = OPEN
        result[endIdx] = CLOSE
    }
    return result.joinToString("")
}
