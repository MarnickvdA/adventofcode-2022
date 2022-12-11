package day1

import Challenge
import java.nio.file.Paths.*


/**
 * One important consideration is food: the number of Calories each Elf is carrying (your puzzle input).
 *
 * The Elves take turns writing down the number of Calories contained in an item of food, one item per line.
 * Each Elf separates their own inventory from the previous Elf's inventory (if any) by a blank line.
 *
 * In case the Elves get hungry and need extra snacks, they need to know which Elf to ask:
 *      they'd like to know how many Calories are being carried by the Elf carrying the most Calories.
 *
 * In the example above, this is 24000 (carried by the fourth Elf).
 */
class CalorieCounting : Challenge {
    override fun getName(): String {
        return "Day 1 - Calorie Counting"
    }

    /**
     * This challenge contains a simple check for the max calories in a set of calorie items.
     */
    override fun solve(): String {
        val calories = mutableListOf<Int>()
        var curSum = 0;

        fun processLine(line: String) {
            if (line.isEmpty()) {
                calories.add(curSum)
                curSum = 0
            } else {
                curSum += line.toInt()
            }
        }

        // Read file, line per line
        get(System.getProperty("user.dir"), "src", "main", "resources", "day1.txt").toFile()
            .forEachLine { processLine(it) }

        calories.sortDescending()


        return (calories[0] + calories[1] + calories[2]).toString() // 67622
    }
}