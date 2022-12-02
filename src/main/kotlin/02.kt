
fun main() {

    // Part 1
    val pointsForRound: (Char, Char) -> Int = {foo: Char, bar: Char ->
        val pointsForSelected = when (bar) {
            'X' -> 1
            'Y' -> 2
            else -> 3
        }

        val pointsForResult = when (bar) {
            'X' -> if (foo == 'C') 6 else if (foo == 'A') 3 else 0
            'Y' -> if (foo == 'A') 6 else if (foo == 'B') 3 else 0
            else -> if (foo == 'B') 6 else if (foo == 'C') 3 else 0
        }

        pointsForSelected + pointsForResult
    }

    val score = input.split("\n").sumOf {
        pointsForRound(it[0], it[2])
    }

    println(score)


    // Part 2

    val pointsForRound2 = { foo: Char, bar: Char ->
        when (bar) {
            'X' -> 0 + if (foo == 'A') 3 else if (foo == 'B') 1 else 2
            'Y' -> 3 + if (foo == 'A') 1 else if (foo == 'B') 2 else 3
            else -> 6 + if (foo == 'A') 2 else if (foo == 'B') 3 else 1
        }
    }

    val score2 = input.split("\n").sumOf {
        pointsForRound2(it[0], it[2])
    }

    println(score2)
}

private val input = """
    B X
    B Y
    A Y
    B Y
    B Y
    A Y
    A X
    A Y
    C X
    A Y
    A Y
    B Y
    B Z
    A Y
    B Z
    B Z
    B Z
    B Y
    A Z
    A Y
    B X
    A Z
    A Z
    A Z
    B Z
    A Y
    A Z
    C X
    B Z
    A Y
    B Z
    B Y
    A Y
    A Y
    A Y
    A Y
    A Z
    C X
    C Z
    A Y
    A Y
    A X
    C X
    B Z
    B Y
    B Y
    A Y
    C X
    A Y
    B Z
    B Z
    A Y
    B Y
    B Z
    A Y
    C X
    B Y
    A Y
    A Y
    A Y
    A Y
    B Z
    B X
    A Y
    B Y
    A Z
    B Y
    A Y
    C X
    A Z
    C Z
    B Z
    B Y
    A Y
    A Y
    B Z
    B Y
    B Y
    B Y
    B Z
    A X
    A Y
    A Y
    B Z
    C X
    A Y
    B Y
    C Z
    A Y
    C Y
    A Y
    A Y
    C X
    A X
    A Z
    A Y
    B Z
    A Z
    B Z
    A Y
    B Z
    A Y
    A Z
    C X
    C X
    B Y
    A Y
    A Y
    A Y
    A X
    B Y
    B Y
    A Y
    A Y
    A Z
    A Y
    A Z
    B Z
    A Y
    B Z
    A Z
    C Z
    B Y
    A Y
    B Z
    A Y
    B Z
    A Y
    A Y
    A X
    B Y
    A Z
    C Z
    A Y
    B Z
    A Y
    A Y
    A Y
    B Y
    B Z
    B X
    C X
    B Z
    B Y
    C X
    A X
    A Y
    B X
    C X
    B Y
    A Z
    A Z
    A Y
    B Z
    B Y
    C Z
    B Z
    A Y
    B Z
    C Y
    B Y
    A X
    A X
    C X
    B X
    A Y
    C X
    B Z
    A Y
    A Z
    B Y
    B Y
    B Y
    C X
    A Y
    A Y
    B X
    C Y
    A X
    B Y
    B Y
    A Y
    A Y
    B Z
    B X
    A X
    C X
    B Y
    B Y
    B Z
    B Y
    B X
    B Z
    A Y
    A Y
    A X
    B Y
    A Y
    A Y
    B Z
    A Y
    C X
    B Y
    B Z
    C Z
    B Y
    A Y
    A Z
    B Y
    A Y
    B Z
    C Y
    A Y
    A Y
    A Y
    B Y
    A Z
    B Z
    A Y
    C X
    B Y
    B Z
    A Y
    A Z
    A Y
    B Y
    B Z
    A X
    B Y
    A Y
    A Y
    B Y
    A Y
    A Y
    C Z
    B Z
    C X
    B Z
    A Y
    B Y
    B Y
    A X
    A Y
    C X
    B Z
    B Y
    A X
    B Z
    B Y
    B Z
    A Z
    A X
    A Y
    A Y
    B Y
    A X
    B Y
    B Y
    B Z
    B Y
    B Y
    B Y
    A Y
    A Z
    A X
    A X
    C Z
    B Y
    A Z
    A Y
    A Y
    A X
    B Y
    B Z
    C X
    A Y
    B Y
    C X
    B Z
    A Y
    B Z
    B Z
    B Y
    A Z
    C Z
    B Y
    A Y
    B Y
    A Y
    B X
    A X
    B X
    B Z
    A Y
    B Y
    B X
    B Y
    B Z
    A Z
    B Y
    C Z
    B Z
    A Y
    B Z
    C X
    B Y
    B Z
    B Z
    A Y
    A Z
    A Z
    B Y
    C Y
    A Y
    A Y
    A X
    A X
    A Y
    B Y
    B Y
    B Z
    A X
    B Z
    B Y
    B Z
    C Z
    A Y
    C X
    C X
    B Z
    B Z
    B Y
    A Y
    A Y
    A Y
    B Z
    B Y
    A X
    B Z
    B Y
    B X
    B Z
    B Z
    A Z
    B Y
    B Z
    A Y
    B X
    A Y
    A Y
    A Y
    B Y
    A Y
    A Z
    A Y
    A Y
    C X
    A Y
    B Y
    B Y
    A Y
    B Z
    B X
    A Y
    B Y
    A Y
    A X
    C X
    B Z
    A Y
    B Z
    C X
    B Z
    A X
    A Z
    A X
    B Z
    B Y
    A Y
    A Z
    C Z
    B Z
    A Y
    A Z
    A Y
    A Y
    B Z
    B Z
    A X
    A Y
    A X
    B Z
    A Y
    C X
    B Y
    A X
    B Y
    B Y
    B Y
    A Y
    A Z
    B Y
    A Y
    B Z
    B Z
    B Z
    B Z
    A X
    A X
    A X
    B X
    C Y
    C X
    A Z
    B X
    B Y
    A Z
    A X
    A Y
    A Y
    A Y
    B Y
    A Y
    B Z
    B Y
    A Y
    A Y
    A Y
    B Z
    B Y
    B Z
    C X
    B Z
    B Z
    A Z
    B Y
    A Y
    A Y
    B Z
    A Y
    B X
    A X
    A Y
    A Y
    A Y
    C X
    B Y
    B Y
    B Y
    C Y
    A Y
    A Y
    A Y
    B Z
    B Z
    A X
    B Y
    B Y
    B Y
    B Z
    A Z
    B X
    A Y
    A X
    B Z
    A Y
    B Z
    B Y
    A Z
    B Y
    C X
    A Y
    C X
    B Y
    C X
    C X
    B Y
    B Y
    B Z
    B Y
    A Y
    C Y
    A X
    B Y
    B Y
    B Z
    B Y
    B X
    B Z
    B Y
    B X
    B Y
    B Z
    A Y
    B X
    B Z
    B Z
    B X
    B Z
    A Y
    C X
    A Y
    C Y
    B Z
    A X
    A Y
    A X
    C X
    A Z
    A Y
    A Z
    A Y
    C Y
    B Z
    A Y
    B Y
    B Y
    B Y
    B Y
    A Y
    C Z
    B Y
    C Y
    B Y
    B X
    A Z
    A Y
    A Z
    A Y
    B Z
    B Y
    B Y
    A Z
    B Y
    A Y
    B Z
    C Z
    A Y
    A Y
    B Z
    B Y
    A X
    A Y
    B Z
    A Z
    B Y
    A Z
    A X
    B Z
    B Z
    A Y
    A X
    A Y
    B X
    B Y
    B Z
    B Y
    C Z
    B Y
    C X
    A Z
    C X
    B Y
    A Y
    B Y
    C Z
    A Y
    C X
    C X
    A Y
    A Z
    B Y
    A Y
    B Z
    B Z
    A Z
    B X
    B Y
    C X
    A Y
    B Y
    B Z
    A Z
    B Y
    A X
    B Z
    A X
    A X
    B X
    B Y
    B Y
    B Y
    C X
    C Z
    A Y
    B Y
    A Y
    A X
    B Z
    A X
    A Y
    B Y
    B Y
    C Y
    A Y
    B Z
    A Y
    B X
    B Z
    A Y
    A Y
    B Y
    A X
    B Y
    B Z
    A Y
    A X
    C Y
    B Z
    B Y
    B Z
    A Y
    B Y
    A X
    B Z
    A Z
    B Z
    B Y
    B Y
    C Y
    B Y
    B Y
    A Y
    B Z
    A Y
    A Y
    B Z
    A X
    A Z
    B Y
    A Y
    A Y
    A Y
    B Z
    B X
    C X
    A Y
    B Y
    C Z
    A Y
    B Y
    A X
    A Y
    A Y
    A Z
    B Y
    A Y
    A Y
    B Y
    B Z
    A Y
    A Z
    B Y
    A Z
    A Y
    A X
    B Y
    C X
    B Z
    A Y
    A Y
    B Y
    B X
    B Z
    A Y
    C X
    B Y
    A Y
    B Y
    B Z
    C X
    A X
    B Z
    A Y
    A Y
    A Y
    A Y
    B Z
    B Z
    B Y
    B Z
    A Y
    C X
    A Y
    B Y
    B Z
    C X
    C Z
    B Z
    B Z
    A X
    B Z
    B Z
    A Y
    A Y
    A Y
    B Y
    B Y
    C Y
    C Z
    A Y
    B Y
    B Z
    B Z
    C X
    C Z
    A Y
    A Y
    A Z
    A Y
    B Y
    A Y
    A Y
    B Z
    A Y
    B Z
    A X
    B Y
    B Z
    B Y
    B Y
    C X
    C X
    A Y
    B Z
    B Y
    B Y
    A Z
    B Z
    B Y
    A Y
    B Z
    A Y
    B X
    B Z
    A Y
    A Y
    B Z
    B Z
    C X
    A X
    B Y
    B Y
    A Y
    C X
    A Z
    B Z
    A Z
    A X
    A Y
    A X
    A Y
    A Y
    C X
    C X
    B Z
    B Y
    C Y
    A Y
    A Y
    C X
    A X
    C X
    A Y
    B Y
    B Y
    C X
    A X
    A Y
    B Z
    C X
    A Y
    B Y
    A Y
    A X
    B Y
    A X
    B Y
    B Z
    A Y
    B Z
    A Y
    A X
    B Z
    A Z
    A Y
    B Z
    B Y
    A X
    A Y
    A Y
    B Y
    C Z
    A Y
    A Y
    B Z
    B Y
    B Y
    B Y
    A Y
    C Z
    C Y
    A X
    B Y
    B Y
    B Z
    C Y
    B X
    B Z
    A Y
    A Y
    B Z
    B Z
    B Z
    B Y
    B Y
    B Z
    C Y
    B Z
    B Y
    B Z
    A X
    A Y
    C X
    B Y
    B Z
    B Z
    A Y
    A Y
    A Y
    B Y
    A Y
    A Y
    A Y
    B Z
    A Y
    B Z
    B Z
    B X
    B Y
    B Y
    A Y
    B Y
    B Y
    A Y
    A X
    B Z
    A Y
    B Z
    C X
    A Y
    A Y
    B Z
    B Z
    C X
    C Z
    A Y
    B Z
    C Z
    B Y
    B Y
    B Z
    A Z
    A Y
    A Y
    B Y
    C Y
    A Y
    A Y
    B Z
    B Z
    A X
    A Y
    B Y
    A Y
    A Y
    A X
    A X
    B Z
    C Y
    B Y
    A Y
    C X
    B Y
    B Y
    C Z
    B Y
    A Z
    A Y
    A X
    C X
    A Y
    A Y
    B Z
    A X
    B Z
    C X
    C X
    A Y
    B Z
    B Y
    A Y
    A X
    C X
    B Z
    B Z
    B Y
    A Y
    B Z
    C Y
    A Y
    B Y
    A Y
    C X
    B Z
    C X
    A Y
    B Y
    A Z
    A Y
    B X
    B Z
    C Z
    B Y
    B Y
    B Z
    C Z
    A X
    B Z
    A Y
    A Y
    B Z
    A Y
    B Z
    B Z
    B Y
    B Y
    B X
    A Y
    A X
    B Y
    B Y
    A Y
    A Y
    B Z
    A Y
    A X
    C X
    B Z
    B Y
    A Y
    B Z
    B Y
    B Z
    B Z
    B Y
    A Y
    C Y
    A X
    B Y
    A Y
    B Z
    B Y
    B Z
    A Y
    C Z
    B X
    C Z
    B X
    B Y
    A Y
    C X
    A Y
    A Y
    A X
    C X
    A Z
    B Y
    A X
    A Z
    B Y
    A X
    B Y
    A X
    A Y
    B Y
    A Y
    A Y
    C X
    C X
    C Y
    B Y
    C Z
    B Y
    B Z
    C Z
    B Y
    A Z
    A Y
    A X
    A X
    A Z
    A Y
    A Z
    B Z
    B X
    B Y
    B Y
    B Z
    A Y
    A Y
    B Y
    A X
    A Y
    A Y
    B Z
    C X
    C X
    B Y
    A Y
    C X
    C X
    A X
    C X
    A Y
    A Z
    A Z
    C X
    A Y
    B Z
    B Y
    B Z
    C X
    B Z
    A Y
    C Y
    C X
    B Y
    C Z
    A X
    C X
    C X
    A X
    B Y
    A X
    B Z
    B Y
    A Z
    B Y
    A X
    A Y
    B Z
    B Y
    C Z
    B Y
    B Y
    B Z
    A X
    A Z
    B Y
    B Y
    C Z
    A Y
    C X
    B Z
    C Y
    B Z
    A Y
    B Y
    B Z
    A Y
    A Y
    B Z
    A Z
    A Z
    C X
    B Y
    A Y
    A Y
    B Z
    B Y
    A X
    A Z
    B Z
    C Z
    A Y
    B Y
    B X
    C X
    A Y
    B Y
    C Z
    A Z
    C X
    C X
    A Y
    B Y
    B X
    B Y
    A X
    A X
    A X
    A Z
    A X
    B Z
    B Z
    A Z
    A Z
    A Y
    B Y
    B Z
    A Z
    B Z
    B Z
    A Y
    B Y
    A Y
    A Y
    A Y
    C X
    B Y
    C X
    C X
    B Z
    C Y
    A X
    B Y
    B X
    C X
    B X
    A Z
    C X
    C X
    B Y
    A Y
    B Y
    B Y
    B Y
    B X
    B Y
    B Y
    A Y
    B Y
    B X
    B Y
    B Z
    A Z
    A Y
    A Y
    B Z
    A Y
    B Z
    A Y
    A Y
    A Y
    A Z
    B Y
    A X
    B Z
    A Y
    B Y
    A X
    B Z
    B Z
    A Y
    B Y
    B Y
    B Z
    A Y
    B Y
    B Y
    A Y
    A Y
    A Z
    C Y
    B Z
    B Y
    A X
    A Y
    B Z
    C X
    B Z
    C X
    C X
    B Z
    B Y
    C X
    A Z
    A Z
    C Y
    A Y
    B Y
    A Z
    A Y
    B Y
    A Y
    A Z
    A Y
    A Y
    C X
    B Y
    B Y
    B Y
    A X
    C Z
    B Z
    A X
    A Y
    A Z
    A Y
    B Y
    A Y
    B Z
    B Y
    B Z
    C X
    B Y
    B Z
    A Z
    B Y
    B Y
    B Z
    C X
    A Y
    B Y
    A Z
    B Y
    B Z
    B Z
    B Y
    A X
    A Y
    A Y
    B Y
    B Z
    B Y
    B Z
    A Y
    C Y
    A Y
    B Z
    A Y
    B Z
    A X
    A Y
    A Y
    C Y
    C X
    B Y
    A Z
    B Z
    B Z
    B Y
    B Z
    C Z
    C X
    A Y
    B Y
    B Y
    B Y
    B Y
    B Z
    B Z
    B Y
    A X
    A Y
    B Y
    A Y
    A X
    A Y
    B Z
    C Z
    B Y
    A Y
    A Y
    A Y
    C X
    A Y
    B Z
    C Z
    B Y
    B Z
    A Z
    A X
    A Y
    A Y
    A Y
    A Y
    B Z
    B Z
    B Z
    B Z
    A X
    B Y
    B Y
    B Y
    B Y
    B Y
    B Z
    A X
    B Y
    B Y
    B Y
    C Y
    A Y
    A Y
    B Z
    A X
    C Y
    A Y
    A Y
    A Y
    B Y
    B Z
    A Y
    B Y
    B Y
    A Y
    B Y
    A Y
    A X
    A Y
    C Z
    B Z
    B Y
    A Y
    B Y
    B Y
    A Z
    C X
    B Y
    B Z
    C Y
    A Y
    A Y
    B X
    B Y
    A Y
    C Z
    B Y
    B Y
    A X
    A Y
    A Z
    A Y
    C Y
    A Y
    B X
    A Y
    B Z
    B Y
    B Z
    A Y
    A Y
    B Y
    B X
    B Y
    B Z
    B Y
    B X
    A Y
    C Z
    C X
    A Y
    B Z
    A X
    C Z
    B Y
    B Y
    A Y
    A Y
    B Z
    B Z
    A X
    A X
    C X
    A X
    C X
    B Y
    B Y
    B Y
    A Y
    B Y
    B X
    B Z
    A Y
    A X
    A Y
    B Z
    A X
    A Z
    B Y
    A Y
    A Y
    B Z
    B X
    B Z
    C Z
    B Z
    A Y
    B Z
    A X
    A Y
    A Y
    B Y
    B Z
    B Y
    B X
    B Y
    A Y
    A X
    B Y
    A X
    C X
    C X
    A X
    A Y
    A Y
    A X
    B Y
    A X
    B Y
    A X
    B Z
    A Y
    C X
    B Y
    A Y
    B Z
    A Y
    B Y
    A X
    A X
    A Y
    B Z
    B X
    C Y
    B Z
    C Y
    A Y
    A Y
    B Z
    C X
    B Y
    B Z
    B Z
    C Z
    B Z
    C Y
    A Z
    C X
    A Y
    B Z
    A X
    B Z
    A Y
    A Y
    B Z
    A Z
    A Y
    B Z
    B Z
    B Z
    B X
    A Z
    B Y
    B Z
    B Z
    A Y
    B Y
    A Z
    B Z
    B Y
    B Z
    B Y
    B Y
    B Z
    A Y
    B Y
    B X
    A Y
    B Y
    B Y
    B Z
    B X
    A Z
    B Z
    A Y
    B Y
    C X
    A Y
    B Z
    B Y
    A Y
    C X
    B Z
    A Y
    C X
    A X
    A Y
    B Z
    A Z
    A Y
    B X
    A Y
    C X
    A Y
    B Y
    B Y
    B Z
    B X
    A Z
    B Y
    A Y
    B Z
    A Y
    C Y
    A Z
    A Y
    A Y
    B Y
    B Z
    A Y
    B Y
    A Y
    A Y
    B Z
    B Y
    C Z
    A Y
    B Y
    A Z
    A X
    C X
    A Y
    B Z
    B Z
    C X
    A Y
    B Y
    A Y
    A X
    A Y
    A X
    A X
    C X
    B Y
    A Y
    A Y
    B Y
    A Z
    C Y
    A Y
    A X
    B Z
    A Y
    A Y
    A Y
    B Y
    C X
    A Y
    C Z
    A Y
    C Y
    C X
    B Y
    B Y
    C X
    C Z
    B Z
    A Y
    A Y
    B Y
    B Y
    A Y
    C X
    A X
    B X
    B Y
    C X
    B Y
    C Z
    B Z
    A Y
    B Y
    B Z
    B X
    A Y
    A Y
    B Y
    A Y
    B Z
    B Z
    B Z
    A Y
    B Y
    B X
    B Z
    A Z
    B Z
    A X
    C Y
    B Z
    B Y
    C X
    B Y
    A Z
    A Y
    B Z
    A Y
    A Z
    A Y
    A Y
    B X
    C X
    B Y
    B X
    B X
    C X
    A Y
    B Y
    B Y
    A Z
    B Z
    C X
    B Y
    B Y
    A Y
    A Y
    B Z
    A Y
    A X
    A X
    A Z
    B Y
    A X
    A Y
    C Z
    A Y
    A X
    B X
    A Y
    B Y
    A Y
    B X
    A Y
    A Y
    A Y
    B Y
    C X
    A Y
    A Y
    B Z
    C X
    A X
    A Y
    A Y
    A Y
    A Y
    C X
    A Z
    C X
    B Y
    B Y
    A X
    C X
    B Z
    B Y
    B Z
    A Y
    B Y
    A Y
    B Y
    A Y
    B Z
    C Z
    B Z
    A Z
    A X
    A Z
    A Y
    B Y
    B Z
    A Y
    B Z
    A Z
    A Y
    B Y
    B Y
    B Z
    A Y
    A Y
    C X
    C X
    C Z
    A Y
    B Z
    A Y
    A X
    B Y
    A X
    B Z
    A Y
    B Z
    B Y
    B Y
    B Z
    A Y
    B Y
    A Y
    B Z
    A Y
    C X
    A X
    A Y
    B Y
    C X
    A Y
    C Y
    B Z
    A Y
    B Y
    A Y
    A Y
    A Y
    A Y
    B Z
    B Z
    A Z
    B Z
    A X
    A X
    C X
    B X
    A Y
    A Y
    A X
    C Z
    B Z
    A Z
    B Y
    B Y
    A Y
    A X
    B Z
    A Y
    A Y
    B Y
    B Y
    B Y
    A X
    A X
    A X
    A X
    A X
    A X
    B Y
    C X
    A Y
    C X
    A X
    B Z
    C X
    B Y
    A X
    B Z
    A Y
    B Y
    B Y
    B Z
    B Y
    B X
    B Z
    C X
    C X
    A Y
    A X
    B Z
    B Y
    B Z
    C X
    A Y
    C Z
    C X
    C Z
    B Y
    B Z
    B Z
    B Y
    A Y
    B X
    A Y
    B Y
    B Z
    B Y
    A Y
    B Z
    A X
    B Y
    C X
    B Y
    B Y
    B Y
    A X
    C X
    C X
    C Z
    A Y
    A Y
    B X
    B Z
    A X
    B Z
    A X
    B Z
    B Z
    B Z
    B Y
    B Y
    A Z
    C Z
    B Z
    B Y
    B Z
    B Z
    C X
    B Y
    C Y
    A Y
    C X
    A Z
    B Z
    B Z
    A X
    B Y
    A Z
    B Y
    B Z
    A X
    C Y
    A Y
    A Y
    B Y
    A Y
    A X
    A Z
    B Z
    C Z
    A Y
    B Y
    B Z
    B Y
    B Y
    B Z
    B X
    A X
    C X
    C X
    A Y
    A X
    A Y
    A Y
    A Y
    A X
    B X
    C X
    B Y
    B Z
    A X
    A Y
    B Y
    A X
    A Y
    A Y
    A Y
    B Y
    A Y
    B Z
    B Y
    C Z
    A Y
    A Z
    C X
    B Z
    B X
    C Z
    A Y
    A Z
    A Y
    B Z
    B Z
    C X
    B Z
    C X
    B Y
    C X
    B Y
    A Z
    B Y
    A Y
    C Z
    B Y
    B Y
    B X
    B X
    A X
    B Y
    B Y
    B Z
    A X
    B Y
    B Z
    B Y
    B Z
    A Y
    B Y
    B Z
    B Y
    C Z
    A Y
    C Y
    C Z
    A Y
    B X
    C X
    C X
    B Z
    C X
    A Z
    C Y
    B Z
    B Z
    C X
    C Z
    A Y
    B X
    A Z
    C Y
    A Y
    B Y
    B Y
    A Y
    A Z
    B Z
    B X
    A Y
    B X
    A Z
    B Z
    B X
    A X
    A Y
    B Y
    B Y
    B Z
    C X
    B Z
    B Z
    A Y
    C Z
    B Y
    A Y
    C Y
    B Z
    B Z
    B Y
    A Y
    C Z
    B Y
    B Y
    A Y
    A Z
    B Z
    A Y
    C Y
    A Y
    A Y
    A Y
    A Y
    C Y
    B Y
    B Z
    A Y
    B Y
    A X
    B Y
    B Z
    A Y
    B Y
    B Y
    A Z
    B Y
    C X
    B X
    C X
    B Y
    A X
    A Z
    B Z
    B Z
    A Z
    A Z
    B X
    A Z
    A X
    B Z
    B Y
    B Y
    B Z
    B Y
    B Y
    B Z
    B Y
    B Y
    A Y
    B Z
    B Y
    A Y
    A Y
    B Y
    A Y
    A Y
    A Y
    C Y
    B Y
    A X
    A Y
    B Z
    B Y
    B Y
    C Z
    A Y
    C X
    C X
    A Z
    B Z
    B Y
    B Z
    A X
    B Y
    A Y
    A X
    B Y
    B Z
    B Z
    A X
    A X
    A Y
    B Z
    A Y
    C X
    A Y
    C X
    A Y
    C X
    B Y
    B Z
    A Z
    C Z
    B Y
    B Y
    B Z
    A Y
    A Y
    C X
    B Z
    B Z
    B Z
    A X
    A X
    B Z
    B Y
    C Z
    A Y
    B Y
    A X
    C Y
    B Y
    B Y
    B Y
    B Y
    B Z
    B Z
    A Y
    A Y
    A Y
    B Z
    B Z
    A X
    A Y
    C Z
    B Z
    C Z
    A X
    C Z
    B Z
    B Z
    A Z
    A Z
    A Y
    A Y
    A Y
    A X
    C X
    B Z
    A Y
    B Y
    A X
    B Z
    B Z
    B Y
    B Y
    B Y
    A Y
    B Y
    C X
    A Y
    A Y
    B Z
    B Z
    A Z
    A Z
    A X
    B Z
    B Z
    B Y
    C X
    C X
    A Y
    B Y
    A X
    B Y
    B Y
    B X
    B Y
    B Y
    B Z
    B Y
    B Z
    B X
    A Y
    A X
    B Y
    B Z
    A X
    A Y
    B Z
    B Z
    B Z
    A Y
    A Y
    B Z
    A Y
    B Y
    B Z
    A Y
    B Z
    A Y
    C X
    B Y
    A X
    A Y
    B Y
    B Y
    B Y
    B Z
    A Y
    B Z
    A Z
    B Z
    A Y
    B Z
    B Z
    A Y
    B Y
    A Z
    C X
    A Y
    A Y
    B Z
    C Z
    B X
    B Z
    A Y
    C Y
    B Z
    B Y
    B Y
    A X
    B Y
    A X
    A Y
    B Y
    A Y
    B Z
    A Y
    A X
    C X
    A Y
    B Z
    C Z
    A Y
    B Y
    B Y
    B Y
    B Y
    C X
    A Z
    B Y
    B Z
    B X
    A Y
    B X
    A Y
    A Y
    B Y
    A Z
    B Y
    B Y
    C X
    C X
    B Y
    C X
    B Y
    C Z
    C Y
    B Y
    A X
    A Y
    C X
    B Y
    B Z
    C X
    B Y
    A Y
    B Y
    B Z
    A Y
    B Z
    C X
    A Y
    B Y
    B Z
    A Z
    B X
    B Y
    B Z
    B Y
    A Y
    A Y
    B X
    B Y
    B X
    B Y
    C X
    A Y
    A X
    A Z
    A Y
    B Z
    C Y
    C X
    B Y
    B Z
    A Y
    B Y
    B Z
    A Y
    A Y
    B Y
    B Z
    B Y
    A Y
    B X
    A X
    A Y
    B Y
    A Y
    A Y
    A Y
    B Y
    A Y
    B Y
    A X
    C X
    A Y
    A Y
    B Y
    B Y
    B Y
    C Y
    C X
    B Z
    B X
    A Z
    B Y
    A X
    B Y
    B Z
    B Z
    A Y
    B Y
    A X
    B Y
    C X
    B Z
    A X
    A Y
    B Y
    B Z
    A Y
    B X
    A Y
    A Y
    C Z
    C Z
    C Y
    A Y
    B Z
    A Y
    A X
    A Y
    A Y
    C X
    B X
    A X
    A Y
    B Z
    B Y
    B Z
    B Y
    C Y
    B Z
    B Y
    B Y
    A Y
    B Z
    B Z
    B Y
    B Z
    B Z
    B X
    C X
    A Y
    A Y
    B X
    C X
    B Z
    B Y
    A Y
    B Y
    B Z
    A Y
    B Y
    B Y
    B Z
    A X
    B Y
    B Z
    B Z
    A Y
    B Z
    B Z
    B Z
    C X
    C X
    B Z
    B Y
    B Y
    B Z
    B X
    B Y
    C Y
    A Y
    A X
    A Y
    A Z
    C X
    A Z
    B Z
    A Y
    B Y
    A Y
    B Y
    A X
    B Y
    B X
    A X
    C Z
    A X
    A Y
    A Y
    C Y
    B Y
    A X
    A X
    B Y
    C Y
    B Z
    B Z
    B Y
    A Y
    A X
    A Y
    A Y
    A Z
    A X
    A Y
    A Y
    A Y
    B Z
    C X
    A X
    C X
    A Y
    A Y
    B Y
    B Y
    A X
    B Y
    C Y
    B Y
    A Z
    B Y
    B Z
    C X
    A X
    B Y
    A Z
    B Z
    B Y
    B Y
    B Y
    B Z
    B Y
    B Y
    B Y
    A X
    A Y
    B Z
    C X
    A Y
    A Y
    B Y
    B Z
    C X
    A X
    A Y
    B X
    B Y
    A Y
    A Z
    A X
    A Z
    A Y
    C Z
    A Y
    B Y
    B Y
    B Z
    C X
    B Z
    A Z
    B Y
    B Z
    B Y
    A Y
    A Y
    C Z
    A Y
    B Z
    B Y
    B Y
    A X
    B Y
    A Y
    B Y
    A Y
    A Y
    C X
    A Y
    B Y
    A Y
    C X
    B X
    A Y
    B Z
    A Y
    A Y
    C Z
""".trimIndent()