package trading

import kotlinx.coroutines.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.random.Random

fun main() {
    level1()
    level1_inplace_edge_case()
    level2()
    level3_sequential()
    level3_concurrent()
    level3_inplace()
    level4_sequential()
    level4_concurrent()
    level4_inplace()
}

fun level1() {

    val api = Api(10, 25, 1)

    val start = System.currentTimeMillis()
    val calc = Calculator(api)
    val stop = System.currentTimeMillis()
    if (calc.getBuyDay() == 1 && calc.getSellDay() == 2) {
        print("Level 1 success ")
    } else {
        print("Level 1 failure ")
    }
    println("- ${stop - start} ms")

}

fun level2() {

    val api = Api(30, 35, 100)

    val start = System.currentTimeMillis()
    val calc = Calculator(api)
    val stop = System.currentTimeMillis()
    if (calc.getBuyDay() == 11 && calc.getSellDay() == 27) {
        print("Level 2 success ")
    } else {
        print("Level 2 failure ")
    }
    println("- ${stop - start} ms")
}

fun level3_sequential() {
    val api = Api(3000, 150, 3000)

    val start = System.currentTimeMillis()
    val calc = Calculator(api)
    val stop = System.currentTimeMillis()

    if (calc.getBuyDay() == 343 && calc.getSellDay() == 348) {
        print("Level 3 sequential success ")
    } else {
        print("Level 3 sequential failure ")
    }
    println("- ${stop - start} ms")
}


fun level3_concurrent() {
    val api = Api(3000, 150, 3000)

    val start = System.currentTimeMillis()
    val calc = ConcurrentCalculator(api)
    val stop = System.currentTimeMillis()

    val diff = api.getPrice(calc.getSellDay()) - api.getPrice(calc.getBuyDay())

    if (diff == 149) {
        print("Level 3 concurrent success ")
    } else {
        print("Level 3 concurrent failed ")
    }
    println("- ${stop - start} ms")
}

fun level3_inplace() {
    val api = Api(3000, 150, 3000)

    val start = System.currentTimeMillis()
    val calc = InPlaceCalculator(api)
    val stop = System.currentTimeMillis()

    val diff = api.getPrice(calc.getSellDay()) - api.getPrice(calc.getBuyDay())

    if (diff == 149) {
        print("Level 3 in place success ")
    } else {
        print("Level 3 in place failed ")
    }
    println("- ${stop - start} ms")
}

fun level4_sequential() {
    val api = Api(11_000, 10_001, 300_000)

    val start = System.currentTimeMillis()
    val calc = Calculator(api)
    val stop = System.currentTimeMillis()


    val diff = api.getPrice(calc.getSellDay()) - api.getPrice(calc.getBuyDay())

    if (diff == 10_000) {
        print("Level 4 sequential success ")
    } else {
        print("Level 4 sequential failure ")
    }
    println("- ${stop - start} ms")
}


fun level4_concurrent() {
    val api = Api(40_000, 10_001, 300_000)

    val start = System.currentTimeMillis()
    val calc = ConcurrentCalculator(api)
    val stop = System.currentTimeMillis()

    val diff = api.getPrice(calc.getSellDay()) - api.getPrice(calc.getBuyDay())

    if (diff == 10_000) {
        print("Level 4 concurrent success ")
    } else {
        print("Level 4 concurrent failed ")
    }
    println("- ${stop - start} ms")
}

fun level4_inplace() {
    val api = Api(40_000, 10_001, 300_000)

    val start = System.currentTimeMillis()
    val calc = InPlaceCalculator(api)
    val stop = System.currentTimeMillis()

    val diff = api.getPrice(calc.getSellDay()) - api.getPrice(calc.getBuyDay())

    if (diff == 10_000) {
        print("Level 4 in place success ")
    } else {
        print("Level 4 in place failed ")
    }
    println("- ${stop - start} ms")
}

fun level1_inplace_edge_case() {
    val api = Api(10, 25, 1)
    api.prices = listOf(100, 1, 2, 3, 1, 1, 4, 0, 1, 2)

    val start = System.currentTimeMillis()
    val calc = InPlaceCalculator(api)
    val stop = System.currentTimeMillis()
    if (calc.getBuyDay() == 1 && calc.getSellDay() == 6) {
        print("Level 1 in place edge success ")
    } else {
        print("Level 1 in place edge failure ")
    }
    println("- ${stop - start} ms")
}

class Calculator(api: Api) {

    private val buyDay : Int
    private val sellDay : Int

    private data class Diff(val diff: Int, val buyDay: Int, val sellDay: Int)

    init {

        val days = api.getNumberOfDays()
        val prices = (0 until days).map { api.getPrice(it) }

        val diffs = prices.dropLast(1).mapIndexed { index, price ->
            (index+1 until prices.size).map { undex ->
                Diff(prices[undex] - price, index, undex)
            }
        }.flatten()

        val max = diffs.maxBy { it.diff }

        buyDay = max.buyDay
        sellDay = max.sellDay
    }

    fun getBuyDay() = buyDay
    fun getSellDay() = sellDay
}

data class Diff(val diff: Int, val buyDay: Int, val sellDay: Int)

class ConcurrentCalculator(api: Api) {

    private val buyDay : Int
    private val sellDay : Int

    init {
        val days = api.getNumberOfDays()

        val diffs = ConcurrentHashMap<Int, Diff>()
        val prices = (0 until days).map { api.getPrice(it) }

        prices.mapIndexed { index, price ->
            CoroutineScope(Job()).launch {
                diffs[index] = calculateHighestDiff(index, price, prices.drop(index))
            }
        }.last().also {
            runBlocking { it.join() }
        }

        val max = diffs.values.maxBy { it.diff }

        buyDay = max.buyDay
        sellDay = max.sellDay
    }

    fun getBuyDay() = buyDay
    fun getSellDay() = sellDay

    private fun calculateHighestDiff(buyDay: Int, initialPrice: Int, prices: List<Int>): Diff {
        var highestDiff = 0
        var sellDay = 0

        prices.forEachIndexed { index, price ->
            val diff = price - initialPrice
            if (diff > highestDiff) {
                highestDiff = diff
                sellDay = buyDay + index
            }
        }

        return Diff(highestDiff, buyDay, sellDay)
    }
}

class InPlaceCalculator(api: Api) {

    private val dayOfMinPrice: Int
    private val dayOfMaxDiff: Int

    init {
        val days = api.getNumberOfDays()
        val prices = (0 until days).map { api.getPrice(it) }

        var maxDiff = prices[1] - prices[0]
        var minElement = prices[0]
        var minElementDay = 0
        var buyDay = 0
        var sellDay = 0

        prices.forEachIndexed { day, price ->
            if (price - minElement > maxDiff) {
                maxDiff = price - minElement
                sellDay = day
                buyDay = minElementDay
            }
            if (price < minElement) {
                minElement = price
                minElementDay = day
            }
        }

        dayOfMinPrice = buyDay
        dayOfMaxDiff = sellDay
    }


    fun getBuyDay() = dayOfMinPrice
    fun getSellDay() = dayOfMaxDiff
}

class Api(private val days: Int, private val maxPrice: Int, private val seed: Int) {

    var prices: List<Int> = (1..days).map { Random(seed + it).nextInt(maxPrice) }

    fun getNumberOfDays() = days
    fun getPrice(day: Int) = prices[day]
}