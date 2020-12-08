package jessewebb.aoc2020

import scala.io.Source

object PuzzleInput {

  lazy val Day01: String = getResourceAsString("inputs/day01.txt")
  lazy val Day02: String = getResourceAsString("inputs/day02.txt")
  lazy val Day03: String = getResourceAsString("inputs/day03.txt")

  private def getResourceAsString(resource: String): String = {
    val inputStream = getClass.getClassLoader.getResourceAsStream(resource)
    Source.fromInputStream(inputStream).mkString
  }

}
