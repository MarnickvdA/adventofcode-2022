import challenges.*
import java.io.File
import java.nio.file.Paths.*

fun main() {
    val challenges = mutableListOf(
//        CalorieCounting(),
//        RockPaperScissors(),
//        RucksackReorganization(),
//        CampCleanup(),
//        SupplyStacks(),
//        TuningTrouble(),
        NoSpaceLeftOnDevice()
    )

    challenges.forEach { println("%s: %s".format(it.getName(), it.solve(getFile(it.getInputFileName())))) }
}

fun getFile(fileName: String): File {
    return get(System.getProperty("user.dir"), "src", "main", "resources", fileName).toFile()
}