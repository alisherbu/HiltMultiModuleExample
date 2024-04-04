package kaa.alisherbu.data

import kotlin.random.Random

class RandomRepository {
    fun getRandomNumber(): Int {
        return Random.nextInt(1000)
    }
}