package jessewebb.aoc2020

object Program extends App {

  def solveDay01(): Unit = {
    println("Day 01\n======")
    import jessewebb.aoc2020.day01._
    val input = PuzzleInput.Day01
    val expenses = input.split('\n').map(_.trim.toInt).toList
    val answer1 = Part1.solve(expenses)
    println(s"Part 1: $answer1")
    val answer2 = Part2.solve(expenses)
    println(s"Part 2: $answer2")
  }

  def solveDay02(): Unit = {
    println("Day 02\n======")
    import jessewebb.aoc2020.day02._
    val input = PuzzleInput.Day02
    val passwordsAndPolicies1 = input.split('\n').map(Part1.parseInput).toList
    val answer1 = Part1.solve(passwordsAndPolicies1)
    println(s"Part 1: $answer1")
    val passwordsAndPolicies2 = input.split('\n').map(Part2.parseInput).toList
    val answer2 = Part2.solve(passwordsAndPolicies2)
    println(s"Part 2: $answer2")
  }

  def solveDay03(): Unit = {
    println("Day 03\n======")
    import jessewebb.aoc2020.day03._
    val input = PuzzleInput.Day03
    val grid = input.split('\n').map(_.toCharArray.toList).toList
    val answer1 = Part1.solve(grid)
    println(s"Part 1: $answer1")
    val answer2 = Part2.solve(grid)
    println(s"Part 2: $answer2")
  }

  def solveDay04(): Unit = {
    println("Day 04\n======")
    import jessewebb.aoc2020.day04._
    val input = PuzzleInput.Day04
    val passports = Part1.parseInput(input)
    val answer1 = Part1.solve(passports)
    println(s"Part 1: $answer1")
  }

//  solveDay01()
//  solveDay02()
//  solveDay03()
  solveDay04()

}
