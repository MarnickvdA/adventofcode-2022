package challenges

import Challenge
import java.io.File as IOFile

class NoSpaceLeftOnDevice : Challenge {
    override fun getName(): String {
        return "Day 7 - No Space Left On Device"
    }

    override fun getInputFileName(): String {
        return "day7.txt"
    }

    override fun solve(input: IOFile?): String {
        val directories = mutableMapOf<String, Directory>()
        val root = Directory("/", parent = null)
        directories["/"] = root
        var curDir = root

        input!!.forEachLine {
            val arguments = it.split(" ")

            when {
                it.startsWith("$") && arguments[1] == "cd" -> curDir = when (arguments[2]) {
                    "/" -> root
                    ".." -> directories[curDir.parent]!!
                    else -> directories[arguments[2]]!!
                }

                it.startsWith("dir") -> {
                    val dir = Directory(arguments[1], curDir.name)
                    curDir.content.add(dir)
                    directories[dir.name] = dir
                }

                !it.startsWith("$") -> curDir.content.add(File(arguments[1], arguments[0].toLong(), curDir.name))
            }
        }

        var sum = 0L
        directories.values.forEach {
            val size = it.getTotalSize()
            println("${it.name.padEnd(10, ' ')}size=\t$size")
            if (size <= 100_000) sum += size
        }

        return sum.toString()
    }

    open class Node(open val name: String, open val parent: String?)
    data class File(override val name: String, val size: Long, override val parent: String?) : Node(name, parent)
    data class Directory(
        override val name: String,
        override val parent: String?,
        val content: MutableList<Node> = mutableListOf()
    ) : Node(name, parent) {
        fun getTotalSize(): Long {
            return content.sumOf { (it as? File)?.size ?: (it as Directory).getTotalSize() }
        }
    }
}

