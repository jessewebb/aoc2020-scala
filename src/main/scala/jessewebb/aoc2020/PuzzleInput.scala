package jessewebb.aoc2020

import scala.io.Source

object PuzzleInput {

  lazy val Day01 = getResourceAsString("inputs/day01.txt")
  lazy val Day02 = getResourceAsString("inputs/day02.txt")

  private def getResourceAsString(resource: String): String = {
    val inputStream = getClass.getClassLoader.getResourceAsStream(resource)
    Source.fromInputStream(inputStream).mkString
  }

}
