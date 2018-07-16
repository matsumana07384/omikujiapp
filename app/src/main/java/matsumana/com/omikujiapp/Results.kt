package matsumana.com.omikujiapp

import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

enum class Result {
    大吉,
    吉,
    中吉,
    小吉,
    末吉,
    凶,
    大凶}

fun getRandomly(): Result {
    val arr = Result.values()
    val num: Int = Random().nextInt(arr.size)

    var count = 0
    for (item in arr) {
        if (count == num)
            return item
        else
            count++
    }
    return arr[0]
}

fun main(args: Array<String>) {
    val item = getRandomly()
    println(item)
//    resultTextView.text = item.toString()
}
