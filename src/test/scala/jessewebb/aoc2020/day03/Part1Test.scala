package jessewebb.aoc2020.day03

import jessewebb.aoc2020.day03.Slope
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Part1Test extends AnyFunSuite with Matchers {

  test("countTreesInSlope Simple 2x2 with Slope 1,1") {
    val grid = List(
      List('.', '.'),
      List('.', '.'),
    )
    val slope = Slope(1, 1)
    val count = countTreesInSlope(grid)(slope)
    count shouldBe 0
  }

  test("countTreesInSlope Simple 3x3 with Slope 1,1") {
    val grid = List(
      List('.', '.', '.'),
      List('.', '#', '.'),
      List('.', '.', '.'),
    )
    val slope = Slope(1, 1)
    val count = countTreesInSlope(grid)(slope)
    count shouldBe 1
  }

  test("countTreesInSlope Simple 3x3 with Slope 2,1") {
    val grid = List(
      List('.', '.', '.'),
      List('.', '#', '.'),
      List('.', '.', '.'),
    )
    val slope = Slope(2, 1)
    val count = countTreesInSlope(grid)(slope)
    count shouldBe 0
  }

  test("Example") {
    val grid = List(
      List('.','.','#','#','.','.','.','.','.','.','.'),
      List('#','.','.','.','#','.','.','.','#','.','.'),
      List('.','#','.','.','.','.','#','.','.','#','.'),
      List('.','.','#','.','#','.','.','.','#','.','#'),
      List('.','#','.','.','.','#','#','.','.','#','.'),
      List('.','.','#','.','#','#','.','.','.','.','.'),
      List('.','#','.','#','.','#','.','.','.','.','#'),
      List('.','#','.','.','.','.','.','.','.','.','#'),
      List('#','.','#','#','.','.','.','#','.','.','.'),
      List('#','.','.','.','#','#','.','.','.','.','#'),
      List('.','#','.','.','#','.','.','.','#','.','#'),
    )
    val count = Part1.solve(grid)
    count shouldBe 7
  }
}
