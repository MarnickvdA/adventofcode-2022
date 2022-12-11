package day2

import Challenge

class RockPaperScissors: Challenge {
    override fun getName(): String {
        return "Day 2 - Rock Paper Scissors"
    }

    /**
     * "The first column is what your opponent is going to play:
     *      A for Rock,
     *      B for Paper, and
     *      C for Scissors. The second column--"
     *
     *      X for Rock, Y for Paper, and Z for Scissors
     *
     * The winner of the whole tournament is the player with the highest score.
     * Your total score is the sum of your scores for each round.
     * The score for a single round is the score for the shape you selected
     * (1 for Rock, 2 for Paper, and 3 for Scissors)
     * plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won)
     */
    override fun solve(): String {
        TODO("Not yet implemented")
    }
}